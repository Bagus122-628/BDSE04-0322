const frontend = document.getElementById("frontend");
const backend = document.getElementById("backend");
const coursePath = document.querySelector(".course-path-content");

frontend.addEventListener("click", () => {
  coursePath.innerHTML = showFrontEnd();
});

backend.addEventListener("click", () => {
  coursePath.innerHTML = showBackEnd();
});

// Front-End Course
function showFrontEnd() {
  return `<div class="header">
            <div class="wrapper">
              <h3>Front-End Web Developer</h3>
              <p><i class="fa-solid fa-book-bookmark"></i> 3 Classes</p>
            	<p><i class="fa-solid fa-graduation-cap"></i> 12k Students</p>
            </div>
            <div class="description">
            	<p>
                The curriculum is prepared by ABC Learning Center and industry
                players in the field of Web Development. Students are prepared
                to become Front-End Web Developers according to industry
                standards.
            	</p>
            </div>
        	</div>
        	<hr />
        	<div class="content-box-wrapper">
            <div class="content-box">
							<img src="img/Logo/html.png" alt="" />
							<div class="text">
								<h4>HTML5</h4>
								<p><i class="fa-solid fa-star"></i> 4,89</p>
								<p><i class="fa-solid fa-award"></i> Beginner</p>
							</div>
            </div>
            <div class="content-box">
							<img src="img/Logo/css.png" alt="" />
							<div class="text">
								<h4>CSS3</h4>
								<p><i class="fa-solid fa-star"></i> 4,84</p>
								<p><i class="fa-solid fa-award"></i> Beginner</p>
							</div>
            </div>
            <div class="content-box">
							<img src="img/Logo/javascript.png" alt="" />
							<div class="text">
								<h4>Javascript</h4>
								<p><i class="fa-solid fa-star"></i> 4,82</p>
								<p><i class="fa-solid fa-award"></i> Intermediate</p>
							</div>
            </div>
        	</div>`;
}

// Back-End Course
function showBackEnd() {
  return `<div class="header">
            <div class="wrapper">
              <h3>Back-End Developer</h3>
              <p><i class="fa-solid fa-book-bookmark"></i> 3 Classes</p>
            	<p><i class="fa-solid fa-graduation-cap"></i> 8k Students</p>
            </div>
            <div class="description">
            	<p>
								The curriculum was compiled by ABC Learning Center together with
								AWS and the Back-End Development industry. Students are prepared
								to become Back-End Developers according to industry needs.
            	</p>
            </div>
        	</div>
        	<hr />
        	<div class="content-box-wrapper">
						<div class="content-box">
							<div class="content-box-image-wrapper">
								<img src="img/Logo/javascript.png" alt="" />
							</div>
							<div class="text">
								<h4>Javascript</h4>
								<p><i class="fa-solid fa-star"></i> 4,82</p>
								<p><i class="fa-solid fa-award"></i> Beginner</p>
							</div>
						</div>
            <div class="content-box">
							<div class="content-box-image-wrapper">
								<img src="img/Logo/java.png" alt="Java" />
							</div>
							<div class="text">
								<h4>Java</h4>
								<p><i class="fa-solid fa-star"></i> 4,79</p>
								<p><i class="fa-solid fa-award"></i> Intermediate</p>
							</div>
            </div>
            <div class="content-box">
							<div class="content-box-image-wrapper">
								<img src="img/Logo/aws.png" alt="AWS" />
							</div>
							<div class="text">
								<h4>AWS</h4>
								<p><i class="fa-solid fa-star"></i> 4,89</p>
								<p><i class="fa-solid fa-award"></i> Intermediate</p>
							</div>
            </div>
        	</div>`;
}
