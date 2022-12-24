import { Link } from "react-router-dom";
import SearchByPriceRangeForm from "../../Search/SearchByPriceRangeForm";
import "./Sidebar.css";

const Sidebar = (props) => {
  return (
    <aside className="sidebar me-sm-4 pt-3 mb-3">
      <ul className="fw-semibold">
        <li className="ms-1">
          <Link to="/">
            <i className="fa-solid fa-car"></i> Car List
          </Link>
        </li>
        <li>
          <Link to="/post-car">
            <button className="btn btn-warning">Post a car</button>
          </Link>
        </li>
        <li>
          <p className="ms-1">
            <i className="fa-solid fa-dollar-sign"></i> Price Range
          </p>
          <SearchByPriceRangeForm />
        </li>
      </ul>
    </aside>
  );
};

export default Sidebar;
