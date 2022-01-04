import { useState } from "react";
import './Login.css'

const Login = ({onLogin}) => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        const userInfo = {
            "email" : email,
            "password" : password
        }
        fetch("http://localhost:8080/api/user/login", {
                    method: "POST",
                    headers: {
                        'Content-type': 'application/json'
                    },
                    body: JSON.stringify(userInfo)
                })
                .then(response => response.json())
                .then(data => {
                    if (data==null){
                        alert("User not found")
                    }else{
                    onLogin(data.id)}})
    }

    return (
        <div className="login-container">
            
            <form className="login-form" onSubmit={handleSubmit}>
                <h1>Login</h1>
                <label>Email:</label><input type="text" value={email} onChange={(e) => {setEmail(e.target.value)}}></input>
                <label>Password:</label><input type="password" value={password} onChange={(e) => {setPassword(e.target.value)}}></input>
                <input type="submit"></input>
            </form>

        </div>
    )
}

export default Login;