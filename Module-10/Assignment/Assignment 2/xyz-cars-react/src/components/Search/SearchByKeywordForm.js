import { useRef } from "react";
import { useNavigate } from "react-router-dom";

const SearchByKeyword = () => {
  const navigate = useNavigate();
  const inputKeywordRef = useRef();

  const onSubmitHandler = (e) => {
    e.preventDefault();
    const keywordValue = inputKeywordRef.current.value;

    navigate(`/cars?keyword=${keywordValue}`);
    inputKeywordRef.current.value = "";
  };

  return (
    <form id="searchForm" className="d-flex" onSubmit={onSubmitHandler}>
      <input
        ref={inputKeywordRef}
        className="form-control"
        type="text"
        name="keyword"
        required
        placeholder="Search by Make, Model, or Year"
      />
      <button type="submit" className="btn btn-light">
        <i className="fa-solid fa-magnifying-glass"></i>
      </button>
    </form>
  );
};

export default SearchByKeyword;
