"use client";
import React, { useEffect, useState } from "react";
import Head from "next/head";
import { useSession } from "next-auth/react";

export default function Update() {
  const { data } = useSession();
  const [user, setUser] = useState<any>({});
  const [formData, setFormData] = useState({
    name: "",
    surname: "",
    email: "",
    cell: "",
  });
  useEffect(() => {
    const userReq = fetch("/api/get-user", {
      method: "POST",
      body: JSON.stringify({ email: data?.user.email }),
    })
      .then(async (v) => {
        const dataRes = await v.json();
        setUser(dataRes);
        setFormData({
          name: dataRes.name,
          surname: dataRes.surname,
          email: dataRes.email,
          cell: dataRes.phone,
        });
      })
      .catch((err: any) => console.log(err));
  }, []);

  console.log(user);
  const [isEditing, setIsEditing] = useState(false);

  const handleInputChange = (e: { target: { name: any; value: any } }) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSave = () => {
    fetch("/api/update-user", {
      method: "POST",
      body: JSON.stringify({
        userId: user.userId,
        name: formData.name,
        surname: formData.surname,
        email: formData.email,
        phone: formData.cell,
        password: user.password,
      }),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((data) => {
        alert("Success! " + data.name);
        console.log(data); // Response from the server
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  const handleCancel = () => {
    // Reverting the changes and exit edit mode
    setFormData({
      name: user.name,
      surname: user.surname,
      email: user.email,
      cell: user.phone,
    });
    setIsEditing(false);
  };

  return (
    <div
      className="flex justify-center items-center h-screen text-slate-50"
      style={{
        backgroundImage: `linear-gradient(rgba(20, 7, 7, 0.568),
            rgba(18, 13, 13, 0.457)),url("/img/bg.gif")`,
      }}
    >
      <Head>
        <title>Update Personal Information</title>
      </Head>
      <div
        className="form-container w-1/2 bg-form"
        style={{
          padding: "20px",
        }}
      >
        <h1 className="text-center font-bold text-slate-50 text-2xl">
          User Information
        </h1>
        <div className="input-container" style={{ marginBottom: "15px" }}>
          <label
            htmlFor="name"
            style={{ display: "block", fontWeight: "bold" }}
          >
            Name:
          </label>
          <input
            className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleInputChange}
            style={{
              width: "100%",
              padding: "10px",
              border: "1px solid #ccc",
              borderRadius: "5px",
            }}
            readOnly={!isEditing}
          />
        </div>
        <div className="input-container" style={{ marginBottom: "15px" }}>
          <label
            htmlFor="surname"
            style={{ display: "block", fontWeight: "bold" }}
          >
            Surname:
          </label>
          <input
            type="text"
            id="surname"
            name="surname"
            value={formData.surname}
            onChange={handleInputChange}
            style={{
              width: "100%",
              padding: "10px",
              border: "1px solid #ccc",
              borderRadius: "5px",
            }}
            className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
            readOnly={!isEditing}
          />
        </div>
        <div className="input-container" style={{ marginBottom: "15px" }}>
          <label
            htmlFor="email"
            style={{ display: "block", fontWeight: "bold" }}
          >
            Email:
          </label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleInputChange}
            style={{
              width: "100%",
              padding: "10px",
              border: "1px solid #ccc",
              borderRadius: "5px",
            }}
            className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
            readOnly={!isEditing}
          />
        </div>
        <div className="input-container" style={{ marginBottom: "15px" }}>
          <label
            htmlFor="cell"
            style={{ display: "block", fontWeight: "bold" }}
          >
            Cell Number:
          </label>
          <input
            className=" bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
            type="tel"
            id="cell"
            name="cell"
            value={formData.cell}
            onChange={handleInputChange}
            style={{
              width: "100%",
              padding: "10px",
              border: "1px solid #ccc",
              borderRadius: "5px",
            }}
            readOnly={!isEditing}
          />
        </div>
        {isEditing ? (
          <div className="button-container" style={{ marginTop: "20px" }}>
            <button
              onClick={handleSave}
              style={{
                padding: "10px 20px",
                backgroundColor: "#007bff",
                color: "#fff",
                border: "none",
                borderRadius: "5px",
                cursor: "pointer",
              }}
            >
              Save
            </button>
            <button
              onClick={handleCancel}
              style={{
                padding: "10px 20px",
                backgroundColor: "#dc3545",
                color: "#fff",
                border: "none",
                borderRadius: "5px",
                cursor: "pointer",
                marginLeft: "10px",
              }}
            >
              Cancel
            </button>
          </div>
        ) : (
          <div className="text-center pt-3">
            <button
              onClick={() => setIsEditing(true)}
              className="shadow bg-orange-600 hover:bg-orange-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 w-64 rounded"
            >
              Edit
            </button>
          </div>
        )}
      </div>
    </div>
  );
}

// export default Update;
