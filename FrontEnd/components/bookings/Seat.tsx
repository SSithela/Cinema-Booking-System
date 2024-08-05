"use client";
import React, { useEffect, useState } from "react";

const Seat = ({ seat, setBooking, booking, movieShow }: any) => {
  const [selected, isSelected] = useState(false);
  // console.log(movieShow);
  // const data=fetch("");
  const [reserved, setReserved] = useState<any>({});
  useEffect(() => {
    // console.log(seat);
    async function getReservedSeats() {
      await fetch("/api/reserved-seats", {
        method: "POST",
        body: JSON.stringify({ movieShow: movieShow, seat: seat }),

        // mode: "no-cors",
      })
        .then(async (v) => {
          const data = await v.json();
          console.log(data);
          setReserved(data);
        })
        .catch((err) => console.log(err));
    }
    getReservedSeats();
  }, []);
  // console.log(reserved);
  return (
    <div className="h-10 w-10 bg-slate-700">
      <button
        disabled={reserved.reserved}
        onClick={() => {
          isSelected(!selected);
          !selected
            ? setBooking([...booking, seat])
            : setBooking(
                booking.filter(
                  (v: { seatNum: any }) => v.seatNum !== seat.seatNum
                )
              );
        }}
        className={`h-10 w-10 ${selected && "bg-orange-600"} ${
          reserved.reserved && "bg-purple-500"
        }`}
      >
        {seat.seatNum}
      </button>
    </div>
  );
};

export default Seat;
