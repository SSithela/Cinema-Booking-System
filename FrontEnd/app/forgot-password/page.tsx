"use client";
import NavBar from "@/components/NavBar";
import Link from "next/link";
import React, { useState } from "react";

const Page = () => {
  const [email, setEmail] = useState("");

  const handleSubmit = (e: { preventDefault: () => void }) => {
    e.preventDefault();
    console.log(email);
  };
  return (
    <div>
      {/* <NavBar /> */}
      <div
        className="h-screen flex justify-center items-center text-slate-50"
        style={{
          backgroundImage: `linear-gradient(rgba(20, 7, 7, 0.568),
          rgba(18, 13, 13, 0.457)),url("/img/bg.gif")`,
        }}
      >
        <div className="w-1/2 bg-form p-4">
          <form onSubmit={handleSubmit}>
            <h2 className="text-center font-bold ">
              Forgot password
            </h2>
            <div className="m-3">
              <label htmlFor="email" className="">
                Email:
              </label>
              <input
                className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                type="email"
                id="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
            <div className="text-center">
              <button
                className="w-64 shadow bg-orange-600 hover:bg-orange-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounde"
                type="submit"
              >
                Send
              </button>
            </div>
            <div className="text-right font-bold">
              <Link href={"/login"}>{"<<<"}</Link>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};
export default Page;
