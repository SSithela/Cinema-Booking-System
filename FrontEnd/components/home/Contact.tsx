"use client";
import React, { useState, useEffect } from "react";

import emailjs from "emailjs-com";

const EMAILJS_USER_ID = process.env.EMAILJS_USER_ID || "";
const EMAILJS_SERVICE_ID = process.env.EMAILJS_SERVICE_ID || "";
const EMAILJS_TEMPLATE_ID = process.env.EMAILJS_TEMPLATE_ID || "";

const Contact = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    message: "",
  });
  const [messageSent, setMessageSent] = useState(false);

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleClear = () => {
    setFormData({
      name: "",
      email: "",
      message: "",
    });
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    emailjs
      .send(EMAILJS_SERVICE_ID, EMAILJS_TEMPLATE_ID, formData, EMAILJS_USER_ID)
      .then((response) => {
        console.log("Email sent successfully:", response);
        setMessageSent(true);
        alert("Email sent successfully");
        handleClear(); // Clear the form
      })
      .catch((error) => {
        console.error("Email sending failed:", error);
        // Handle the error if needed
      });
  };

  // Use useEffect to hide the popup after a few seconds
  useEffect(() => {
    if (messageSent) {
      const popupTimeout = setTimeout(() => {
        setMessageSent(false);
      }, 7000); // Hide the popup after 3 seconds
      return () => clearTimeout(popupTimeout);
    }
  }, [messageSent]);

  return (
    <div className="contact-container">
      <div className="small-cards">
        <div className="small-card">
          <i className="fas fa-headset"></i>{" "}
          {/* Replace with appropriate icon */}
          <h2>Helpdesk</h2>
          <p>Get help and support</p>
        </div>
        <div className="small-card">
          <i className="fas fa-briefcase"></i>{" "}
          {/* Replace with appropriate icon */}
          <h2>Careers</h2>
          <p>Explore career opportunities</p>
        </div>
        <div className="small-card">
          <i className="far fa-calendar-alt"></i>{" "}
          {/* Replace with appropriate icon */}
          <h2>Events</h2>
          <p>Discover upcoming events</p>
        </div>
      </div>

      <div className="contact-card">
        <h1 className="text-5xl font-bold text-gold mb-4">Contact Us</h1>

        {messageSent && (
          <div className="message-sent-popup">
            <div className="message-sent-content">Message sent!</div>
          </div>
        )}

        <div className="mb-4 flex">
          <div className="w-1/2 pr-4">
            <p className="text-lg font-semibold text-black mb-2">
              Contact Details:
            </p>
            <p className="text-sm text-black">Company: Sapphire Studios</p>
            <p className="text-sm text-black">Location: NMJ WoodStock</p>
          </div>
          <div className="w-1/2">
            <form onSubmit={handleSubmit}>
              <div className="mb-4">
                <label
                  htmlFor="name"
                  className="block text-black font-semibold mb-2"
                >
                  Name
                </label>
                <input
                  type="text"
                  id="name"
                  name="name"
                  value={formData.name}
                  onChange={handleChange}
                  className="w-full px-3 py-2 rounded border focus:ring-yellow-500 focus:border-yellow-500"
                  placeholder="Your Name"
                />
              </div>
              <div className="mb-4">
                <label
                  htmlFor="email"
                  className="block text-black font-semibold mb-2"
                >
                  Email
                </label>
                <input
                  type="email"
                  id="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  className="w-full px-3 py-2 rounded border focus:ring-yellow-500 focus:border-yellow-500"
                  placeholder="Your Email"
                />
              </div>
              <div className="mb-4">
                <label
                  htmlFor="message"
                  className="block text-black font-semibold mb-2"
                >
                  Message
                </label>
                <textarea
                  id="message"
                  name="message"
                  rows={6}
                  value={formData.message}
                  onChange={handleChange}
                  className="w-full px-3 py-2 rounded border focus:ring-yellow-500 focus:border-yellow-500"
                  placeholder="Your Message"
                ></textarea>
              </div>
              <div className="flex justify-between">
                <button
                  type="button"
                  onClick={handleClear}
                  className="border border-yellow-300 bg-yellow-200 text-black py-2 px-4 rounded-md hover:bg-yellow-300 hover:text-black transition duration-300"
                >
                  Clear
                </button>
                <button
                  type="submit"
                  className="border border-black bg-black text-yellow-300 py-2 px-4 rounded-md hover:bg-yellow-300 hover:text-black transition duration-300"
                >
                  Submit
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Contact;
