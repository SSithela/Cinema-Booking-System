import React from "react";
import Head from "next/head";
import Link from "next/link";

function About() {
  return (
    <div
      className="min-h-screen flex items-center justify-center p-3"
      // style={{ backgroundImage: "url('Img/aboutBackground.jpg')" }}
    >
      <div
        style={{
          content: '""',
          // position: "absolute",
          top: 0,
          right: 0,
          bottom: 0,
          left: 0,
          // backgroundColor: "rgba(0, 0, 0, 0.5)", // Adjust the alpha value (0.5) to control darkness
        }}
      ></div>
      <Head>
        <title>About Us</title>
      </Head>
      <div className="text-center">
        <h1 className="text-gold text-2xl font-bold text-orange-700">
          BOOK NOW!!!!
        </h1>
        <p
          style={{ color: "004225", fontWeight: "bold", fontSize: "20px" }}
          className="px-4 pb-4 mt-2"
        >
          At SaphireScreenStudios, we believe that going to the movies is not
          just about watching a film; it's about embarking on a captivating
          journey, creating unforgettable memories, and sharing magical moments
          with your loved ones. We are more than just a cinema; we are an
          experience, and we're thrilled to have you with us.
        </p>
        <h2 className="text-gold text-2xl font-bold text-orange-700">
          OUR MISSION
        </h2>
        <p
          style={{ color: "004225", fontWeight: "bold", fontSize: "20px" }}
          className="px-4 pb-4 mt-2"
        >
          Our mission is simple: to provide you with an unparalleled cinematic
          adventure. We're not just here to show you movies; we're here to
          transport you to new worlds, evoke emotions, and make your time with
          us a cherished part of your life. We aim to be the heartbeat of your
          community, a place where you can escape, dream, and be inspired.
        </p>
        <h3 className="text-gold text-2xl font-bold text-orange-700">
          WHAT SETS US APART:
        </h3>
        <p
          style={{ color: "004225", fontWeight: "bold", fontSize: "20px" }}
          className="px-4 pb-4 mt-2"
        >
          Unmatched Comfort: Our plush seating, spacious legroom, and
          cutting-edge technology promise the utmost comfort during your movie
          journey. We've invested in the latest cinema technology, ensuring that
          your audio and visual experience is second to none. Be ready to be
          immersed in the magic of the big screen. Our concession stands offer a
          variety of mouthwatering snacks, gourmet popcorn, and refreshing
          beverages to complement your movie night. You won't leave hungry!
          We're deeply committed to our community. [Your Cinema Name] is not
          just a place to watch movies; it's a place to connect, celebrate, and
          create lasting memories.
        </p>
        {/**/}

        {/* <h2 className="text-gold text-2xl font-bold text-orange-700">FOR MORE INFORMATION:</h2>
        <ul className="text-left mt-2">
          <li>
            <a
              className="text-blue-500"
              href="https://www.facebook.com/SapphireScreenStudios"
              target="_blank"
              rel="noopener noreferrer"
            >
              Facebook
            </a>
          </li>
          <li>
            <a
              className="text-blue-500"
              href="https://twitter.com/SaphireScreenStudios"
              target="_blank"
              rel="noopener noreferrer"
            >
              Twitter
            </a>
          </li>
          <li>
            <a
              className="text-blue-500"
              href="https://www.instagram.com/SaphireScreenStudios"
              target="_blank"
              rel="noopener noreferrer"
            >
              Instagram
            </a>
          </li>
        </ul>
        <p className="mt-4">
          **Customer Support:** - Email:{" "}
          <a href="mailto:support@m$mVisio.com" className="text-blue-500">
            support@m$mVisio.com
          </a>
          - Phone: <span className="text-blue-500">0870871234</span>
        </p> */}
      </div>
    </div>
  );
}
export default About;
