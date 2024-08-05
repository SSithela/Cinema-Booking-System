// import { PrismaAdapter } from "@next-auth/";
// import { PrismaClient } from "@prisma/client";
import { AuthOptions } from "next-auth";
import NextAuth from "next-auth/next";
import Credentials from "next-auth/providers/credentials";
const bcrypt = require("bcrypt");
import { z } from "zod";
// const prisma = new PrismaClient();
const loginSchema = z.object({
  email: z.string().min(1, ""),
  password: z.string().min(1, ""),
});
const authOptions: AuthOptions = {
  // adapter: PrismaAdapter(prisma),
  providers: [
    Credentials({
      credentials: {
        email: { type: "text", placeholder: "test@test.cokm" },
        password: { type: "password", placeholder: "Pas$$word" },
      },
      async authorize(credentials, req) {
        const { email, password } = loginSchema.parse(credentials);
        const user = await fetch("http://localhost:8084/user/" + email, {
          method: "GET",
          headers: {
            "X-API-KEY": process.env.SPRING_API_KEY || "",
            "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
          },
        })
          .then((v) => v.json())
          .catch((err) => err.message);
        console.log(user);
        if (!user) return null;
        const hpw: boolean = await bcrypt.compare(password, user.password);
        // const passwordIsValid = await bcrypt.compare(password.toString(), hpw);

        if (hpw) return user as any;
        return null;
      },
    }),
  ],
  callbacks: {
    session({ session, token }) {
      // console.log(token);
      session.user.id = token.id;
      return session;
    },
    jwt({ token, account, user }) {
      if (account) {
        token.accessToken = account.access_token;
        token.id = user.id;
        // console.log("users" + user);
      }

      return token;
    },
  },
  pages: {
    signIn: "/login",
  },
  session: {
    strategy: "jwt",
  },
  secret: process.env.NEXTAUTH_SECRET,
};

export default NextAuth(authOptions);
