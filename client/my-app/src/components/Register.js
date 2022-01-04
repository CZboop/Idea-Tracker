import { useState } from "react";

const Register = () => {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        if (password != confirmPassword){
            alert("Your passwords do not match, please try again")
        }
        else{
            const newUser = {
                "username": username,
                "email": email,
                "password": password
            }
            fetch("http://localhost:8080/api/user/signup", {
                    method: "POST",
                    headers: {
                        'Content-type': 'application/json'
                    },
                    body: JSON.stringify(newUser)
                })
            setUsername("");
            setEmail("");
            setPassword("");
            setConfirmPassword("");
        }

    }

    return(
        <div className="register-container">
            <h1>Register</h1>
            <form className="register-form" onSubmit={handleSubmit}>
                <label>Username:</label><input type="text" value={username} onChange={(e) => setUsername(e.target.value)}></input>
                <label>Email:</label><input type="text" value={email} onChange={(e) => setEmail(e.target.value)}></input>
                <label>Password:</label><input type="password" value={password} onChange={(e) => setPassword(e.target.value)}></input>
                <label>Confirm Password:</label><input type="password" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)}></input>
                <input type="submit"/>
            </form>

        </div>
    )

}

export default Register;