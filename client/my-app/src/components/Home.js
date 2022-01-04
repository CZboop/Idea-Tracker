const Home = ({token}) => {
    return (
        <div className="home-container">
            <h1>Home</h1>
            {
                token?
                <h2>Welcome</h2>
                :
                <>
                <h2>Create an account to use this site!</h2>
                </>
            }
        </div>

    )
}

export default Home;