// src/components/Footer.jsx

import React from "react";
import "./Footer.css";
import { FaYoutube, FaFacebook, FaInstagram, FaLinkedin, FaPhone, FaEnvelope, FaMapMarkerAlt } from "react-icons/fa";
import { TbTextSize } from "react-icons/tb";

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-container">
        <div className="footer-section about">
          <img src="/static/media/e_logo.433f3a23da0204b33a45.png" alt="Logo" className="footer-logo" />
          <a class="navbar-brand-name" href="/"><i><b class="text-color-second ms-2">Learn Management System</b></i></a>
          <h3>Learn With LMS</h3>
          <p>
          Learn with LMS offers expertly crafted courses and hands-on learning experiences to help you master technology and build your future.
          </p>
          <p className="coding">!! Happy Coding !!</p>
        </div>

        <div className="footer-section links">
          <h4>Products</h4>
          <ul>
            <li>Master Spring Boot Course</li>
            <li>React JS Ecommerce Course</li>
            <li>React + Spring Boot Full Stack</li>
            <li>Free Courses</li>
          </ul>
        </div>

        <div className="footer-section contact">
          <h4>Contact</h4>
          <p><FaMapMarkerAlt /> Panipat, INDIA</p>
          <p><FaEnvelope /> kashyap888985@gmail.com</p>
          <p><FaPhone /> +91-7496065575</p>
        </div>

        <div className="footer-section social">
          <h4>Social Media</h4>
          <div className="social-icons">
            <FaYoutube />
            <FaFacebook />
            <FaInstagram />
            <FaLinkedin />
          </div>
        </div>
      </div>

      <div className="footer-bottom">
        <p>© 2025 LMS Technologies Pvt Ltd. All Rights Reserved.</p>
        <div className="footer-links">
          <a href="#">Refund Policy</a>
          <a href="#">Privacy Policy</a>
          <a href="#">Terms of Service</a>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
