import { NextApiRequest, NextApiResponse } from "next";

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  const data = req.body;
  console.log(data);
  const updateUser = await fetch("http://localhost:8084/user/update-user", {
    method: "POST",
    headers: {
      "X-API-KEY": process.env.SPRING_API_KEY || "",
      "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
  const response = await updateUser.json();
  console.log(response);
  res.send(response);
}
