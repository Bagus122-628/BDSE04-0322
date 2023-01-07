import React from "react";
import { Link, useParams } from "react-router-dom";
import MainLayout from "../../components/layout/MainLayout";
import useStore from "../../hooks/useStore";

const StoreDetailPage = () => {
  const { storeId } = useParams();
  const { store, user, editPermission, error } = useStore(storeId);

  return (
    <MainLayout>
      {!error && (
        <div className="text-primary">
          <p>User Id: {user.userId}</p>
          <p>{store.storeName}</p>
          <p>{store.country}</p>
          <p>{store.city}</p>
          <p>{store.storeEmail}</p>
          <p>{store.phoneNumber}</p>
          {editPermission && (
            <Link to="edit" className="text-color1">
              Edit
            </Link>
          )}
        </div>
      )}
      {error && <p className="text-primary">Store not found!!</p>}
    </MainLayout>
  );
};

export default StoreDetailPage;
