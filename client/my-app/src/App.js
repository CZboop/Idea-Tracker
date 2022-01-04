import './App.css';
import React from "react";
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';

import Profile from './components/Profile';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';

function App() {
  return (
    <div className="App">
      <h1>Idea and Project Tracker</h1>
      <BrowserRouter>
      <Navbar  />
        <Routes> 
            <>
              <Route exact path="/" element={<Navigate to="/home" />} /> 
              <Route path="/profile" element={<Profile  />} />
              <Route path="/home" element={<Home  />} />
              <Route path="/login" element={<Login  />} />
              <Route path="/register" element={<Register  />} />
            </>
            
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
