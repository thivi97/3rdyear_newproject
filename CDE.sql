CREATE TABLE `userinfo` (
  `fname` varchar(20) DEFAULT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `uname` varchar(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `conpassword` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `userinfo` (`fname`, `lname`, `uname`, `email`, `password`, `conpassword`) VALUES ('vinojan', 'paskaran', 'vini', 'vino@gmail.com', 'ranger12', 'ranger12');
INSERT INTO `userinfo` (`fname`, `lname`, `uname`, `email`, `password`, `conpassword`) VALUES ('nusry', 'kaleel', 'kcare', 'vetha@gmail.com', 'washin12', 'washin12');