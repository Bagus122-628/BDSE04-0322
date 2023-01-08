import React, { useContext } from "react";
import { Link } from "react-router-dom";
import MainLayout from "../../components/layout/MainLayout";
import AuthContext from "../../context/auth-context";

const ProfilePage = () => {
  const { profile, stores } = useContext(AuthContext);

  return (
    <MainLayout>
      <div className="flex flex-col justify-center mt-10">
        <div className="mb-5">
          <h2 className="font-medium text-xl">Profile</h2>
          <p>{profile.userId}</p>
          <p>{profile.name}</p>
          <p>{profile.address}</p>
          <p>{profile.phoneNumber}</p>
          <Link to="edit" className="text-color1">
            Edit Profile
          </Link>
        </div>

        <div>
          <h2 className="font-medium text-xl">Stores</h2>
          {stores.map((store) => (
            <div key={store.storeId} className="flex flex-wrap space-x-2 mb-2">
              <p>{store.storeId}.</p>
              <p>{store.storeName}</p>
              <p>{store.country}</p>
              <p>{store.city}</p>
              <p>{store.storeEmail}</p>
              <p>{store.phoneNumber}</p>
            </div>
          ))}
        </div>
      </div>
    </MainLayout>
  );
};

export default ProfilePage;
