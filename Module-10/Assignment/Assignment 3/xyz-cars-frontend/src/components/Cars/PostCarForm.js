import axios from "axios";
import { useContext, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import AuthContext from "../../context/auth-context";

import "../Auth/AuthForm.css";

const PostCarForm = () => {
  const authCtx = useContext(AuthContext);
  const navigate = useNavigate();
  const [postCarStatus, setPostCarStatus] = useState("");

  const inputMakeRef = useRef();
  const inputModelRef = useRef();
  const inputYearRef = useRef();
  const inputPriceRef = useRef();

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const inputMake = inputMakeRef.current.value;
    const inputModel = inputModelRef.current.value;
    const inputYear = inputYearRef.current.value;
    const inputPrice = inputPriceRef.current.value;

    axios
      .post(
        "http://localhost:8080/api/cars/post",
        {
          make: inputMake,
          model: inputModel,
          year: inputYear,
          price: inputPrice,
          idUser: authCtx.userId,
        },
        {
          headers: { Authorization: `Bearer ${authCtx.token}` },
        }
      )
      .then((res) => {
        console.log(res.data);
        navigate("/");
      })
      .catch((err) => {
        console.log(err.message);
        setPostCarStatus("FAILED");
      });

    inputMakeRef.current.value = "";
    inputModelRef.current.value = "";
    inputYearRef.current.value = "";
    inputPriceRef.current.value = "";
  };

  return (
    <div className="d-flex justify-content-center">
      <div className="form-auth">
        <h3 className="mb-3 fw-semibold text-center">Post Car</h3>
        {postCarStatus === "FAILED" && (
          <div className="form-error text-center">Failed to post car</div>
        )}
        <form onSubmit={onSubmitHandler}>
          <label className="form-label">Make</label>
          <input
            ref={inputMakeRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="make"
          />

          <label className="form-label">Model</label>
          <input
            ref={inputModelRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="model"
          />

          <label className="form-label">Year</label>
          <input
            ref={inputYearRef}
            className="form-control mb-3 ps-4 pe-0"
            type="text"
            name="year"
          />

          <label className="form-label">Price</label>
          <input
            ref={inputPriceRef}
            className="form-control mb-3 ps-4 pe-0"
            type="number"
            name="price"
          />

          <button
            type="submit"
            className="btn btn-primary"
            style={{ width: "100%" }}
          >
            Post Car
          </button>
        </form>
      </div>
    </div>
  );
};

export default PostCarForm;
