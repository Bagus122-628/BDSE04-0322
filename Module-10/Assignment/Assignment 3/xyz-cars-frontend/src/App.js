import Home from "./pages/Home";
import { Navigate, Route, Routes } from "react-router-dom";
import CarDetail from "./pages/CarDetail";
import Login from "./pages/Login";
import Register from "./pages/Register";
import PostCar from "./pages/PostCar";

import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { useContext } from "react";
import AuthContext from "./context/auth-context";
import OAuth2RedirectHandler from "./components/Auth/OAuth2/OAuth2RedirectHandler";
import Profile from "./pages/Profile";

function App() {
  const authCtx = useContext(AuthContext);

  return (
    <Routes>
      <Route path="/" element={<Navigate to="/cars" replace />} />
      <Route path="/cars" element={<Home />} />
      <Route path="/cars/:make/:model/:year/:carId" element={<CarDetail />} />
      {!authCtx.isLoggedIn && (
        <>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </>
      )}
      <Route
        path="/post-car"
        element={authCtx.isLoggedIn ? <PostCar /> : <Navigate to="/login" />}
      />
      <Route path="/oauth2/redirect" element={<OAuth2RedirectHandler />} />
      <Route
        path="/profile"
        element={authCtx.isLoggedIn ? <Profile /> : <Navigate to="/login" />}
      />
      <Route path="*" element={<Navigate to="/" replace />} />
    </Routes>
  );
}

export default App;
