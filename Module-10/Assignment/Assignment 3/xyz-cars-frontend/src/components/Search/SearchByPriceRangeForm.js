import { useRef } from "react";
import { useNavigate } from "react-router-dom";

const SearchByPriceRangeForm = () => {
  const navigate = useNavigate();

  const inputMinRef = useRef();
  const inputMaxRef = useRef();

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const minValue = inputMinRef.current.value;
    const maxValue = inputMaxRef.current.value;

    navigate(`/cars?min=${minValue}&max=${maxValue}`);
    inputMinRef.current.value = "";
    inputMaxRef.current.value = "";
  };

  return (
    <form onSubmit={onSubmitHandler}>
      <input
        ref={inputMinRef}
        className="form-control mb-3 ps-4 pe-0"
        type="number"
        name="min"
        placeholder="Minimum price"
      />
      <input
        ref={inputMaxRef}
        className="form-control mb-3 ps-4 pe-0"
        type="number"
        name="max"
        placeholder="Maximum price"
      />
      <button type="submit" className="btn btn-secondary">
        Search
      </button>
    </form>
  );
};

export default SearchByPriceRangeForm;
