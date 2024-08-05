import { NextApiRequest, NextApiResponse } from "next";
const bcrypt = require("bcrypt");

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  const { name, surname, email, phone, password } = JSON.parse(req.body);
  const hashPassword = await bcrypt.hash(password, 13);
  const user = await fetch("http://localhost:8084/user/create", {
    method: "POST",
    body: JSON.stringify({
      name,
      surname,
      email,
      phone,
      password: hashPassword,
    }),
    headers: {
      "X-API-KEY": process.env.SPRING_API_KEY || "",
      "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
      "Content-Type": "application/json",
    },
  })
    .then((v) => v.json())
    .catch((err) => console.log(err));

  const data = await user;

  res.send(data);
}
