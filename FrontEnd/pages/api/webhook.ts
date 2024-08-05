import { NextApiRequest, NextApiResponse } from "next";
import getRawBody from "raw-body";
const stripe = require("stripe")(process.env.SECRET_KEY);
export const config = {
  api: {
    bodyParser: false,
  },
};
async function getCartItems(line_items: any) {
  return new Promise((resolve, reject) => {
    let cartItems: any = [];

    line_items?.data?.forEach(async (item: any) => {
      const product = await stripe.products.retrieve(item.price.product);
      const productId = product.metadata.seatId;

      cartItems.push({
        product: productId,
        name: product.name,
        price: item.price.unit_amount_decimal / 100,
        quantity: item.quantity,
        image: product.images[0],
      });

      if (cartItems.length === line_items?.data.length) {
        resolve(cartItems);
      }
    });
  });
}
const webhook = async (req: NextApiRequest, res: NextApiResponse) => {
  //   let event;
  try {
    const rawBody = await getRawBody(req);
    const sig = req.headers["stripe-signature"];
    // console.log(sig);
    const event = stripe.webhooks.constructEvent(
      rawBody,
      sig,
      process.env.WEBHOOK_SECRET_KEY
    );

    if (event.type === "checkout.session.completed") {
      const session = event.data.object;

      const line_items = await stripe.checkout.sessions.listLineItems(
        event.data.object.id
      );
      const getMovieShow = await fetch(
        "http://localhost:8084/show/read/" + session.metadata.movieShow,
        {
          headers: {
            "X-API-KEY": process.env.SPRING_API_KEY || "",
            "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
          },
        }
      ).then((response) => response.json());
      let seatArr: any = [];

      const seats = await fetch(
        "http://localhost:8084/seat/read-data/" + session.metadata.seatId,
        {
          headers: {
            "X-API-KEY": process.env.SPRING_API_KEY || "",
            "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
          },
        }
      ).then((data) => data.json());
      // await seats.map((seat: any) => {
      //   fetch("http://localhost:8084/seat/" + seat, {
      //     headers: {
      //       "X-API-KEY": process.env.SPRING_API_KEY || "",
      //       "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
      //     },
      //   }).then(async (response) => {
      //     const resData = await response.json();
      //     seatArr.push(resData);
      //   });
      // });

      // console.log(getMovieShow);
      console.log(seats);
      // console.log(getMovieShow);

      fetch("http://localhost:8084/booking/create", {
        method: "POST",
        body: JSON.stringify({
          dateMade: session.metadata.dateMade,
          movieShow: getMovieShow,
          seats: seats,
        }),
        headers: {
          "Content-type": "application/json",
          "X-API-KEY": process.env.SPRING_API_KEY || "",
          "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
        },
      }).then((response) => {
        seats.map((seat: any) => {
          fetch("http://localhost:8084/reserved-seats/create", {
            method: "POST",
            body: JSON.stringify({
              reservedSeatId: {
                movieShow: getMovieShow,
                seat: seat,
              },
            }),
            headers: {
              "Content-type": "application/json",
              "X-API-KEY": process.env.SPRING_API_KEY || "",
              "X-API-SECRET": process.env.SPRING_SECRET_KEY || "",
            },
          }).then(async (u) => {
            const t = await u.json();
            console.log(t);
          });
        });
      });
      return line_items;
    }
  } catch (error) {
    console.log(error);
    return res.send(error);
  }
  //   console.log(event);
  return res.send({ name: "sbani" });
};

export default webhook;
