import React, { useEffect, useState } from "react";
import { getCurrentUser, logout as log } from "./Auth";
import { Button } from "reactstrap";
import Base from "./Base";

const Dashboard = () => {
  const [user, setUser] = useState();

  useEffect(() => {
    console.log(getCurrentUser());
    setUser(getCurrentUser());
  }, []);

  const logout = () => {
    log();
  };
  return (
    <Base>
      <div>
        Dashboard{user && <h1>Name : {user.name}</h1>}
        <Button onClick={logout} color="primary">
          Logout
        </Button>
      </div>
    </Base>
  );
};

export default Dashboard;
