"use client";
import NavBar from "@/components/NavBar";
import axios from "axios";
import Link from "next/link";
import React, { useState } from "react";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (e: { preventDefault: () => void }) => {
    e.preventDefault();
    try {
      const response = await fetch("/api/auth/login", {
        method: "POST",
        body: JSON.stringify({ email: email, password: password }),
      }).then((v) => v.json());

      if (response.status) {
        alert(response.status);
      } else {
        setMessage("Login failed. Please check your credentials.");
      }
    } catch (error) {
      setMessage("An error occurred. Please try again later.");
    }
  };

  return (
    <>
      {/* <NavBar /> */}
      <div
        className="flex justify-center items-center h-screen text-slate-50"
        style={{
          backgroundImage: `linear-gradient(rgba(20, 7, 7, 0.568),
          rgba(18, 13, 13, 0.457)),url("/img/bg.gif")`,
        }}
      >
        <div className="w-1/2 bg-form p-4">
          <h2 className="text-center font-bold text-2xl">Login</h2>
          <form onSubmit={handleSubmit}>
            <div className="m-3">
              <label htmlFor="username" className="">
                Username:
              </label>
              <input
                className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
                type="text"
                id="username"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
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
            <div className="pt-3 text-center">
              <button
                className="w-64 shadow bg-orange-600 hover:bg-orange-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded"
                type="submit"
              >
                Login
              </button>
            </div>
            <div className="text-right">
              <Link href="/register">Don't have an account? Register here</Link>
            </div>
            <div className="text-right text-red-600">
              <Link href="/forgot-password">Forgot Password?</Link>
            </div>
          </form>
        </div>
      </div>
    </>
  );
};

export default Login;
