import { NextApiRequest, NextApiResponse } from "next";
const bcrypt = require("bcrypt");
export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  const { email, password } = JSON.parse(req.body);
  console.log(email);
  const user = await fetch("http://localhost:8084/user/" + email, {
    method: "GET",
    headers: {
      "X-API-KEY": process.env.SPRING_API_KEY || "",
      "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
    },
  })
    .then((v) => v.json())
    .catch((err) => err.message);
  const data = await user;
  // console.log(data);
  const isMatch = await bcrypt.compare(password, data.password);
  if (isMatch) {
    return res.send({ status: true, user: data });
  }
  return res.send({ status: false });
}
