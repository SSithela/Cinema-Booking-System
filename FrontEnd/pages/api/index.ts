import { NextApiRequest, NextApiResponse } from "next";

const stripe = require("stripe")(process.env.SECRET_KEY);

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  if (req.method === "POST") {
    const { seats } = req.body;
    // console.log(req.body);

    const arrObj = JSON.parse(req.body);

    const line_items = [
      {
        price_data: {
          currency: "zar",
          product_data: {
            name: "Saphire Screen Studios Ticket",
            // metadata: { seatId: v },
          },
          unit_amount: 250 * 100 * arrObj.seats.seatId.split("-").length,
        },
        quantity: 1,
      },
    ];

    // const metadata = arrObj.seats.map(
    //   (seat: { seatNum: number; seatId: number; price: number }) => {
    //     return {
    //       seatId: seat.seatId,
    //     };
    //   }
    // );
    // console.log(metadata);
    try {
      // Create Checkout Sessions from body params.
      const session = await stripe.checkout.sessions.create({
        metadata: arrObj.seats,
        payment_method_types: ["card"],
        line_items: line_items,
        mode: "payment",
        success_url: `${req.headers.origin}/?success=true`,
        cancel_url: `${req.headers.origin}/?canceled=true`,
      });
      // console.log(session);
      return res.send({ url: session.url });
      // res.redirect(303, session.url);
    } catch (err: any) {
      console.log(err);
      res.status(err.statusCode || 500).json(err.message);
    }
  } else {
    res.setHeader("Allow", "POST");
    res.status(405).end("Method Not Allowed");
  }
}
