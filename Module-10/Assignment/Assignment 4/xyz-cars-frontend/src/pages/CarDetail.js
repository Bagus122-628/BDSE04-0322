import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getCarDetail } from "../service/car-service";

import Car from "../components/Cars/Car";
import Layout from "../components/Layout/Layout";

const CarDetail = () => {
  const [car, setCar] = useState({
    make: "",
    model: "",
    year: "",
    price: "",
  });

  const params = useParams();

  useEffect(() => {
    // Get Car Detail
    getCarDetail(
      params.carId,
      (car) => {
        setCar({
          make: car.make,
          model: car.model,
          year: car.year,
          price: car.price,
        });
      },
      (error) => {
        console.log(error);
      }
    );

    return () => {};
  }, [params.carId]);

  return (
    <Layout>
      <Car {...car} />
    </Layout>
  );
};

export default CarDetail;
