import React from "react";
import { Link } from "react-router-dom";
import { store1 } from "../../assets";

const StoreCard = ({ store }) => {
  const { storeId, storeName, country, city } = store;

  return (
    <div className="shadow-lg overflow-hidden rounded-md">
      <img
        src={store1}
        alt="store"
        className="w-full object-cover max-h-[400px] md:max-h-[300px] lg:max-h-[200px]"
      />
      <div className="px-3 py-3 text-secondary">
        <p className="font-bold text-primary">{storeName}</p>
        <p>{country}</p>
        <p>{city}</p>
      </div>
      <Link
        to={`/stores/${storeName}/${storeId}`}
        className="block py-3 border bg-color1 font-semibold text-center mt-3"
      >
        Show Detail
      </Link>
    </div>
  );
};

export default StoreCard;
