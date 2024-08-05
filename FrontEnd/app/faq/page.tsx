import NavBar from "@/components/NavBar";
import React from "react";

export default function FAQ() {
  return (
    <div className="text-center">
      <>
        {/* <NavBar /> */}
        <h1 className="text-gold text-4xl font-bold">FAQs</h1>
        <h2>
          <i>How can we help you?</i>
        </h2>
        <h3>
          Below you will find answers on the most common question you may have
          on Saphire Screen Studios. If you cannot find answer you're are
          looking for, just <b>Contact Us</b> on our contact page.
        </h3>

        <div className="faq-container">
          <div className="faq-item">
            <div className="question">1. How do I book tickets?</div>
            <div className="answer open">
              You can book tickets by visiting our website and selecting the
              movie, showtime, and number of tickets you want. Then, proceed to
              the checkout and make the payment.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">2. Can I cancel my booking?</div>
            <div className="answer open">
              You can book tickets by visiting our website and selecting the
              movie, showtime, and number of tickets you want. Then, proceed to
              the checkout and make the payment.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">3. How can I pick up my tickets?</div>
            <div className="answer open">
              You can pick up your tickets at the cinema's ticket counter by
              showing your booking confirmation email or presenting your ID.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">
              4. What payment methods are accepted?
            </div>
            <div className="answer open">
              We accept credit cards, debit cards, and various online payment
              methods such as PayPal.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">5. Is there a refund policy?</div>
            <div className="answer open">
              Refunds are available for canceled bookings made within the
              cancellation window. Please refer to our refund policy for more
              details.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">6. Are there discounts for children?</div>
            <div className="answer open">
              Yes, we offer discounts for children under the age of 12. Please
              check our pricing page for more details.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">
              7. Can I change my seat selection after booking?
            </div>
            <div className="answer open">
              Yes, you can change your seat selection before the showtime,
              subject to availability. Please log in to your account and go to
              your bookings to make changes.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">8. Do you have parking facilities?</div>
            <div className="answer open">
              Yes, we have ample parking space available for our customers. It's
              free of charge.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">9. What are your opening hours?</div>
            <div className="answer open">
              We are open from 10:00 AM to 10:00 PM, seven days a week.
            </div>
          </div>

          <div className="faq-item">
            <div className="question">
              10. How can I contact customer support?
            </div>
            <div className="answer open">
              You can contact our customer support team at
              support@cinemabooking.com or call us at +1 (123) 456-7890.
            </div>
          </div>
        </div>

        <footer></footer>
      </>
    </div>
  );
}
