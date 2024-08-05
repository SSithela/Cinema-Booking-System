import { NextApiRequest, NextApiResponse } from "next";

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  const myData = JSON.parse(req.body);
  console.log(myData.seat);
  await fetch("http://localhost:8084/reserved-seats/", {
    method: "POST",
    body: JSON.stringify({
      reservedSeatId: { movieShow: myData.movieShow, seat: myData.seat },
    }),
    headers: {
      "X-API-KEY": process.env.SPRING_API_KEY || "",
      "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
      "Content-Type": "application/json",
    },
    // mode: "no-cors",
  })
    .then(async (v) => {
      const data = await v.json();
      //   console.log(data);
      res.send({ reserved: data });
    })
    .catch((err) => {
      console.log(err);
      res.send(err);
    });
}
