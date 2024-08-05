"use client";
import React, { useState } from "react";

const Login = () => {
  const [email, setEmail] = useState<string>("");
  const [pw, setPW] = useState<string>("");
  function getDetails(e: React.FormEvent<HTMLButtonElement>) {
    e.preventDefault();
    alert("EMail: " + email);
  }
  return (
    <form className="">
      <input
        required
        type="email"
        placeholder="email"
        className=""
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        required
        type="password"
        placeholder="password"
        value={pw}
        onChange={(e) => setPW(e.target.value)}
      />
      <button type="submit" onSubmit={(e) => getDetails(e)}>
        Login
      </button>
    </form>
  );
};

export default Login;
