import './App.css';
import React from "react";
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { useState, useEffect } from 'react';

import Profile from './components/Profile';
import Navbar from './components/Navbar';
import Home from './components/Home';
import Login from './components/Login';
import Logout from './components/Logout';
import Register from './components/Register';

function App() {

  const getSessionStorageOrDefault = (key, defaultValue) => {
    const stored = sessionStorage.getItem(key);
    if (!stored) {
      return defaultValue;
    }
    return JSON.parse(stored);
  }

  const [token, setToken] = useState(getSessionStorageOrDefault('token', null));

  const getUserProjects = (id) => {
    fetch(`http://localhost:8080/api/project/userid/${id}`)
    .then(response => response.json())
    .then(data => setProjects(data))
    .then(data => console.log(data))
}
  const [projects, setProjects] = useState(null);   

  const getUserIdeas = (id) => {
    fetch(`http://localhost:8080/api/ideas/userid/${id}`)
    .then(response => response.json())
    .then(data => setIdeas(data))
    .then(data => console.log(data))
}
  const [ideas, setIdeas] = useState(null); 

  const onLogin = (userId) => {
    fetch(`http://localhost:8080/api/token/get/${userId}`)
    .then(response => response.json())
    .then(data => setToken(data))
    .then(setProjects(getUserProjects(userId)))
    .then(setIdeas(getUserIdeas(userId)))
  }

  const onLogout = () =>{
    setToken(null);
  }

  useEffect(() => {
    sessionStorage.setItem('token', JSON.stringify(token))
  }, [token])

  return (
    <div className="App">
      <BrowserRouter>
      <Navbar  onLogout={onLogout} token={token}/>
        <Routes> 
            <>
              <Route exact path="/" element={<Navigate to="/home" />} /> 
              <Route path="/profile" element={<Profile  token={token} projects={projects} ideas={ideas}/>} />
              <Route path="/home" element={<Home  token={token}/>} />
              <Route path="/login" element={<Login  onLogin={onLogin}/>} />
              <Route path="/logout" element={<Logout  onLogout={onLogout}/>} />
              <Route path="/register" element={<Register  />} />
            </>
            
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
