import { Link } from "react-router-dom";

import "./CarCard.css";

import carImage from "../../assets/car.png";

const CarCard = (props) => {
  return (
    <div className="col-12 col-md-6 col-md-4 col-lg-3 mb-3">
      <div className="card">
        <img className="card-img-top" src={carImage} alt={props.make} />
        <div className="card-body d-flex justify-content-between flex-column">
          <p className="car-details fw-bold m-0">
            {props.make} {props.model} {props.year}
          </p>
          <p className="car-price">${props.price}</p>
          <Link
            className="btn btn-primary btn-car"
            to={`${props.make}/${props.model}/${props.year}/${props.idCar}`}
          >
            Car Details
          </Link>
        </div>
      </div>
    </div>
  );
};

export default CarCard;
