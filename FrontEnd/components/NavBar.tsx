"use client";
import { useSession } from "next-auth/react";
import Link from "next/link";
import React, { useEffect, useState } from "react";

const NavBar = () => {
  const { status, data } = useSession();
  const links = [
    {
      name: "Home",
      link: "/",
    },

    {
      name: "Upcoming",
      link: "/upcoming",
    },
    {
      name: "Now Showing",
      link: "/now-showing",
    },
    {
      name: "Contact",
      link: "/contact",
    },
    {
      name: "About",
      link: "/about",
    },
    {
      name: "Genres",
      link: "/genre",
    },
    {
      name: "FAQ",
      link: "/faq",
    },
    {
      name: status === "authenticated" ? "Profile" : "Login/Register",
      link: status === "authenticated" ? "/dashboard" : "/login",
    },
  ];

  return (
    <div className="navbar p-4 top-0 w-full h-16 z-50 sticky text-gray-100 flex items-center justify-between">
      <div>
        <Link href={"/"}>Saphire Screen Studios</Link>
      </div>
      <div className="flex justify-around">
        {links.map((link) => (
          <div className="m-3 font-sans ">
            <Link href={link.link}>{link.name}</Link>
          </div>
        ))}
      </div>
    </div>
  );
};

export default NavBar;
