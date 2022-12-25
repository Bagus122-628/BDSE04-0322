import axios from "axios";
import { useContext, useRef, useState } from "react";
import AuthContext from "../../context/auth-context";

import "../Auth/AuthForm.css";

const MessageSender = () => {
  const authCtx = useContext(AuthContext);
  const inputTextRef = useRef();

  const [success, setSuccess] = useState("");

  // SUBMIT HANDLER
  const onSubmitHandler = (e) => {
    e.preventDefault();
    const inputText = inputTextRef.current.value;

    axios
      .post(`http://localhost:8080/api/messages/${authCtx.name}`, {
        text: inputText,
      })
      .then((res) => {
        setSuccess("SUCCESS");
      })
      .catch((err) => {
        console.log(err.message);
        setSuccess("ERROR");
      });

    inputTextRef.current.value = "";
  };

  return (
    <div className="d-flex justify-content-center">
      <div className="form-auth">
        <h3 className="mb-3 fw-semibold text-center">Webhook Message Sender</h3>
        <form onSubmit={onSubmitHandler}>
          {success === "SUCCESS" && (
            <div className="form-success text-center">
              Message Sent Successfully!!
            </div>
          )}
          <input
            ref={inputTextRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="text"
            placeholder="Your message"
          />

          <button type="submit" className="btn btn-primary btn-auth">
            Send Message
          </button>
        </form>
      </div>
    </div>
  );
};

export default MessageSender;
