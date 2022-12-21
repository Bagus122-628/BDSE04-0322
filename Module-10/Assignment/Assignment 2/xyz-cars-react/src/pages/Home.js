import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import CarCard from "../components/Cars/CarCard";
import Layout from "../components/Layout/Layout";
import {
  getListCar,
  getSearchByKeyword,
  getSearchByPriceRange,
} from "../service/car-service";

const Home = () => {
  const [searchParams] = useSearchParams();
  const [listCar, setListCar] = useState([]);

  // Get List Car
  useEffect(() => {
    if (
      searchParams.get("keyword") === null &&
      searchParams.get("min") === null &&
      searchParams.get("max") === null
    ) {
      getListCar(
        (data) => {
          setListCar(data);
        },
        (error) => {
          console.log(error);
        }
      );
    }

    return () => {};
  }, [searchParams]);

  // Search By Keyword (Make, Model, Year)
  useEffect(() => {
    if (searchParams.get("keyword") !== null) {
      const keyword = searchParams.get("keyword");

      getSearchByKeyword(
        keyword,
        (data) => {
          setListCar(data);
        },
        (error) => {
          console.log(error);
        }
      );
    }

    return () => {};
  }, [searchParams]);

  // Search By Price Range
  useEffect(() => {
    if (searchParams.get("min") !== null) {
      const min = searchParams.get("min");
      const max = searchParams.get("max");

      getSearchByPriceRange(
        min,
        max,
        (data) => {
          setListCar(data);
        },
        (error) => {
          console.log(error);
        }
      );
    }

    return () => {};
  }, [searchParams]);

  return (
    <Layout>
      <div className="mt-3 row">
        {searchParams.get("keyword") !== null && (
          <p className="text-secondary ms-1">
            Search "{searchParams.get("keyword")}"
          </p>
        )}
        {searchParams.get("min") !== null && (
          <p className="text-secondary ms-1">
            Min price: ${searchParams.get("min")}, Max price: $
            {searchParams.get("max")}
          </p>
        )}
        {listCar.map((car) => (
          <CarCard
            key={car.idCar}
            idCar={car.idCar}
            make={car.make}
            model={car.model}
            year={car.year}
            price={car.price}
          />
        ))}
      </div>
    </Layout>
  );
};

export default Home;
