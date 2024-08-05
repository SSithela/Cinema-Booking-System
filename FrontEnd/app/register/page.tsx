"use client";
import React, { useState, FormEvent } from "react";
import Link from "next/link";
import NavBar from "@/components/NavBar";
import { signIn } from "next-auth/react";

export default function Register() {
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const user = await fetch("/api/auth/register", {
      method: "POST",
      body: JSON.stringify({
        name: name,
        surname: surname,
        email: email,
        phone: phone,
        password: password,
      }),
    })
      .then((v) => v.json())
      .catch((err) => console.log(err));
    console.log(user);
    if (user !== null) {
      await signIn("credentials", {
        email: email,
        password: password,
        callbackUrl: "/dashboard",
      });
    }
  };

  return (
    <>
      {/* <NavBar /> */}
      <div
        className="flex justify-center items-center h-screen"
        style={{
          backgroundImage: `linear-gradient(rgba(20, 7, 7, 0.568),
          rgba(18, 13, 13, 0.457)),url("/img/bg.gif")`,
        }}
      >
        <div className="w-1/2 bg-form p-4">
          <h2 className="text-center font-bold text-slate-50 text-2xl">
            Register
          </h2>
          <form onSubmit={handleSubmit} className="text-slate-50">
            <div className="m-3">
              <label htmlFor="name" className="">
                Name:
              </label>
              <input
                className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                type="text"
                id="name"
                value={name}
                onChange={(e) => setName(e.target.value)}
                required
              />
            </div>
            <div className="m-3">
              <label htmlFor="surname" className="">
                Surname:
              </label>
              <input
                className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                type="text"
                id="surname"
                value={surname}
                onChange={(e) => setSurname(e.target.value)}
                required
              />
            </div>
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
            <div className="m-3">
              <label htmlFor="phone" className="">
                Phone:
              </label>
              <input
                className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                type="text"
                id="phone"
                value={phone}
                onChange={(e) => setPhone(e.target.value)}
                required
              />
            </div>
            <div className="m-3">
              <label htmlFor="password" className="">
                Password:
              </label>
              <input
                className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
            <div className="text-center pt-3">
              <button
                className="shadow bg-orange-600 hover:bg-orange-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 w-64 rounded"
                type="submit"
              >
                Register
              </button>
            </div>
            <div className="text-right">
              <Link href="/login">Already have an Account? Login Here</Link>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}
