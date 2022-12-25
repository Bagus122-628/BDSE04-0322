import "./Car.css";
import carImage from "../../assets/car.png";
import { Link } from "react-router-dom";

const Car = (props) => {
  return (
    <>
      <nav aria-label="breadcrumb ">
        <ol className="breadcrumb mt-3 mb-0 ms-1 fw-bold">
          <li className="breadcrumb-item">
            <Link className="text-decoration-none" to="/cars">
              Cars
            </Link>
          </li>
          <li className="breadcrumb-item active" aria-current="page">
            {props.make} {props.model} {props.year}
          </li>
        </ol>
      </nav>

      <div className="mt-4 row">
        <div className="car-image col-12 col-sm-8">
          <img className="img-fluid" alt={props.make} src={carImage} />
        </div>
        <div className="car-description col-12 col-sm-4">
          <h4 className="fw-bold">
            {props.make} {props.model} {props.year}
          </h4>
          <p className="text-secondary m-0">PRICE:</p>
          <p className="text-black fs-5">${props.price}</p>

          <div className="car-button-actions">
            <button className="btn btn-primary btn-buy">Buy Car</button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Car;
