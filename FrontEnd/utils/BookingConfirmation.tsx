import { PDFDocument, rgb } from 'pdf-lib';
import { useEffect, useState } from 'react';

async function generateBookingPDF(bookingDetails: string, totalPrice: number): Promise<string> {
  // Create a new PDF document
  // i dont if you want to add this on the booking page also 
  const pdfDoc = await PDFDocument.create();
  const page = pdfDoc.addPage([400, 400]);

  // Add booking details and price to the PDF
  page.drawText(`Booking Details: ${bookingDetails}`, {
    x: 50,
    y: 300,
    size: 15,
    color: rgb(0, 0, 0),
  });

  page.drawText(`Total Price: $${totalPrice.toFixed(2)}`, {
    x: 50,
    y: 250,
    size: 15,
    color: rgb(0, 0, 0),
  });

  // Serialize the PDF to bytes
  const pdfBytes = await pdfDoc.save();

  // Create a Blob from the PDF bytes
  const pdfBlob = new Blob([pdfBytes], { type: 'application/pdf' });

  // Create a URL for the Blob
  const pdfUrl = URL.createObjectURL(pdfBlob);

  return pdfUrl; // Return the URL
}

function BookingConfirmation() {
  const [pdfUrl, setPdfUrl] = useState<string | null>(null);

  useEffect(() => {
    // Call the generateBookingPDF function and set the PDF URL
    // here below is just an example since i dont have the booking stuff you can edit accordingly
    const bookingDetails = "Movie: Avengers, Date: 2023-09-15, Time: 7:00 PM, Seats: A1, A2, A3";
    const totalPrice = 25.50;

    generateBookingPDF(bookingDetails, totalPrice).then((url) => {
      setPdfUrl(url);
    });
  }, []);

  return (
    <div>
      <h1> Saphire Screen Studios</h1>
      <h2>Booking Confirmation</h2>
      {pdfUrl && (
        <iframe
          src={pdfUrl}
          width="100%"
          height="600px"
          title="Booking Confirmation"
        />
      )}
      {/* */}
    </div>
  );
}

export default BookingConfirmation;
