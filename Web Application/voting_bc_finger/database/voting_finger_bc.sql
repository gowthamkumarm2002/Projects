-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 25, 2021 at 04:10 PM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `voting_finger_bc`
--

-- --------------------------------------------------------

--
-- Table structure for table `vt_admin`
--

CREATE TABLE `vt_admin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `vdate` varchar(15) NOT NULL,
  `election_st` int(11) NOT NULL,
  `stime` int(11) NOT NULL,
  `etime` int(11) NOT NULL,
  `rdate` varchar(20) NOT NULL,
  `rstime` int(11) NOT NULL,
  `retime` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_admin`
--

INSERT INTO `vt_admin` (`username`, `password`, `vdate`, `election_st`, `stime`, `etime`, `rdate`, `rstime`, `retime`) VALUES
('admin', 'admin', '25-12-2021', 0, 7, 5, '24-12-2021', 7, 5),
('authority', '12345', '', 0, 0, 0, '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `vt_blockchain`
--

CREATE TABLE `vt_blockchain` (
  `id` int(11) NOT NULL default '0',
  `block_id` int(11) NOT NULL,
  `pre_hash` varchar(200) NOT NULL,
  `hash_value` varchar(200) NOT NULL,
  `sdata` varchar(200) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_blockchain`
--

INSERT INTO `vt_blockchain` (`id`, `block_id`, `pre_hash`, `hash_value`, `sdata`, `status`) VALUES
(1, 2, '00000000000000000000000000000000', 'bf1cdcb1ab5d87c1057450a91b21c0be', 'Voter ID:V2,Name:Priya,Register Date:11-03-2020,Division:Trichy', ''),
(2, 3, 'bf1cdcb1ab5d87c1057450a91b21c0be', '65580de8a522e019df4c213a1a39fb4b', 'Voter ID:,Name:Nisha,Register Date:19-12-2021,Division:Trichy', ''),
(3, 4, '65580de8a522e019df4c213a1a39fb4b', '3e48e875a6f16f2d94c332749f6726ab', 'Voter ID:,Name:Krishna,Register Date:20-12-2021,Division:Ramji Nagar', ''),
(4, 5, '3e48e875a6f16f2d94c332749f6726ab', 'bbcfc309a60421d34f1c220ceca3507e', 'Voter ID:V1221005,Name:Sathish,Reg. Date:20-12-2021,Division:Ramji Nagar,Aadhar:432130041266', ''),
(5, 1, 'bbcfc309a60421d34f1c220ceca3507e', 'e4f5a8872c84c2820e0db04a534e5e89', 'Voter ID:V1221001, Name:Raj, Reg.Date:25-12-2021,, Division:, Aadhar:432156784321, Booth:B001, Caption:RMK', ''),
(6, 1, 'e4f5a8872c84c2820e0db04a534e5e89', '99a2fb015bb7868c25d37dfc2f9424dd', 'Voter ID:V1221001, Name:Raj, Reg.Date:25-12-2021,, Division:, Aadhar:432156784321, Booth:B001, Caption:PMK', ''),
(7, 2, '99a2fb015bb7868c25d37dfc2f9424dd', '8afd0b8a13c483e3ee9d0f1031a338df', 'Voter ID:V1221002, Name:Priya, Reg.Date:25-12-2021,, Division:, Aadhar:567801234321, Booth:B001, Caption:RMK', ''),
(11, 1, 'baa78e58310d99ad072dc004b334a50b', 'a730cce4d7133597da2d339ad5726c02', 'Voter ID:V1221001, Name:Raj, Reg.Date:25-12-2021,02:57:23 PM, Division:, Aadhar:432156784321, Booth:, Caption:PMK', 'attack'),
(12, 1, 'a730cce4d7133597da2d339ad5726c02', '4d5567675339e85009fb93ee858eb3f5', 'Voter ID:V1221001, Name:Raj, Reg.Date:25-12-2021,02:58:22 PM, Division:, Aadhar:432156784321, Booth:, Caption:PMK', 'attack'),
(13, 1, '4d5567675339e85009fb93ee858eb3f5', 'ffcb834bdb73561857b1025c612718ee', 'Voter ID:V1221001, Name:Raj, Reg.Date:25-12-2021,03:02:38 PM, Division:, Aadhar:432156784321, Booth:, Caption:PMK', 'attack'),
(14, 6, 'ffcb834bdb73561857b1025c612718ee', '1aef7189e7980403ba44578828ebb342', 'Voter ID:V1221006,Name:Rahul,Reg. Date:25-12-2021,Division:Jayankondam,Aadhar:775544771122', 'reg'),
(15, 7, '1aef7189e7980403ba44578828ebb342', '4bbf3de79738914cbf7948c3ae8201a0', 'Voter ID:V1221007,Name:Suba,Reg. Date:25-12-2021,Division:Coimbatore(North),Aadhar:667788994455', 'reg');

-- --------------------------------------------------------

--
-- Table structure for table `vt_booth`
--

CREATE TABLE `vt_booth` (
  `id` int(11) NOT NULL,
  `booth` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `area` varchar(50) NOT NULL,
  `city` varchar(30) NOT NULL,
  `division` varchar(30) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `uname` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `voterid` varchar(20) NOT NULL,
  `latitude` varchar(30) NOT NULL,
  `longitude` varchar(30) NOT NULL,
  `macaddress` varchar(50) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_booth`
--

INSERT INTO `vt_booth` (`id`, `booth`, `name`, `area`, `city`, `division`, `contact`, `email`, `uname`, `pass`, `voterid`, `latitude`, `longitude`, `macaddress`, `status`) VALUES
(1, 'SS College', 'Ram', 'RR Puram', 'Tiruchirappalli', 'Srirangam', 9976570006, 'ram@gmail.com', 'B001', '9150', '1', '10.83177725', '78.69446575', '', 1),
(2, 'Gov School', 'Saravanan', 'TT Puram', 'Tiruchirappalli', 'Srirangam', 8867833481, 'saravan@gmail.com', 'B002', '12345', '', '', '', '', 0),
(3, 'ST School', 'Vijay', 'NG Nagar', 'Tiruchirappalli', 'Srirangam', 9964327811, 'viji@gmail.com', 'B003', '12345', '', '', '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `vt_candidate`
--

CREATE TABLE `vt_candidate` (
  `id` int(11) NOT NULL,
  `division` varchar(40) NOT NULL,
  `name` varchar(30) NOT NULL,
  `caption` varchar(50) NOT NULL,
  `symbol` varchar(50) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `vcount` int(11) NOT NULL,
  `rdate` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_candidate`
--

INSERT INTO `vt_candidate` (`id`, `division`, `name`, `caption`, `symbol`, `gender`, `age`, `contact`, `vcount`, `rdate`) VALUES
(3, 'Srirangam', 'Ramesh', 'RMK', 'sym3.png', 'Male', 51, '7364788291', 0, ''),
(2, 'Srirangam', 'Vasuki', 'PMK', 'sym2.png', 'Female', 38, '8856772549', 0, ''),
(1, 'Srirangam', 'Raja', 'SMK', 'sym1.png', 'Male', 42, '9867122335', 0, ''),
(4, 'Srirangam', 'Sathish', 'TMK', 'sym4.png', 'Male', 34, '8844623416', 0, '20-12-2021');

-- --------------------------------------------------------

--
-- Table structure for table `vt_division`
--

CREATE TABLE `vt_division` (
  `id` int(11) NOT NULL,
  `district` varchar(30) NOT NULL,
  `division` varchar(40) NOT NULL,
  `vcount` int(11) NOT NULL,
  `vcount2` int(11) NOT NULL,
  `percent` int(11) NOT NULL,
  `detail` varchar(200) NOT NULL,
  `caption` varchar(20) NOT NULL,
  `vnt1` int(11) NOT NULL,
  `vnt2` int(11) NOT NULL,
  `detail1` varchar(200) NOT NULL,
  `caption1` varchar(30) NOT NULL,
  `detail2` varchar(200) NOT NULL,
  `caption2` varchar(30) NOT NULL,
  UNIQUE KEY `division` (`division`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_division`
--

INSERT INTO `vt_division` (`id`, `district`, `division`, `vcount`, `vcount2`, `percent`, `detail`, `caption`, `vnt1`, `vnt2`, `detail1`, `caption1`, `detail2`, `caption2`) VALUES
(58, 'Kancheepuram', 'Alandur', 281, 1585, 17, 'RMK-499,PMK-264,SMK-423,TMK-292', 'RMK', 113, 291, 'RMK-27,PMK-49,SMK-17,TMK-20', 'PMK', 'RMK-67,PMK-59,SMK-78,TMK-87', 'TMK'),
(109, 'Pudukkottai', 'Alangudi', 342, 1077, 31, 'RMK-396,PMK-117,SMK-222,TMK-293', 'RMK', 119, 304, 'RMK-23,PMK-41,SMK-45,TMK-10', 'SMK', 'RMK-94,PMK-98,SMK-51,TMK-61', 'PMK'),
(185, 'Tirunelveli', 'Alangulam', 415, 1550, 26, 'RMK-478,PMK-396,SMK-424,TMK-218', 'RMK', 119, 317, 'RMK-47,PMK-42,SMK-25,TMK-5', 'RMK', 'RMK-90,PMK-89,SMK-53,TMK-85', 'RMK'),
(186, 'Tirunelveli', 'Ambasamudram', 451, 1068, 42, 'RMK-329,PMK-106,SMK-334,TMK-217', 'SMK', 83, 273, 'RMK-31,PMK-14,SMK-13,TMK-25', 'RMK', 'RMK-64,PMK-64,SMK-64,TMK-81', 'TMK'),
(148, 'Thiruvallur', 'Ambattur', 329, 1225, 26, 'RMK-241,PMK-347,SMK-324,TMK-209', 'PMK', 110, 341, 'RMK-14,PMK-36,SMK-31,TMK-29', 'PMK', 'RMK-87,PMK-85,SMK-100,TMK-69', 'SMK'),
(203, 'Vellore', 'Ambur', 298, 1577, 18, 'RMK-413,PMK-470,SMK-202,TMK-328', 'PMK', 98, 314, 'RMK-34,PMK-30,SMK-27,TMK-7', 'RMK', 'RMK-78,PMK-67,SMK-73,TMK-96', 'TMK'),
(204, 'Vellore', 'Anaikattu', 370, 1424, 25, 'RMK-440,PMK-285,SMK-385,TMK-295', 'RMK', 62, 335, 'RMK-7,PMK-10,SMK-40,TMK-5', 'SMK', 'RMK-71,PMK-92,SMK-94,TMK-78', 'SMK'),
(144, 'Theni', 'Andipatti', 353, 1254, 28, 'RMK-349,PMK-153,SMK-295,TMK-388', 'TMK', 78, 243, 'RMK-7,PMK-20,SMK-9,TMK-42', 'TMK', 'RMK-60,PMK-53,SMK-60,TMK-70', 'TMK'),
(3, 'Chennai', 'Anna Nagar', 352, 1310, 26, 'RMK-208,PMK-214,SMK-255,TMK-443', 'TMK', 72, 325, 'RMK-5,PMK-24,SMK-14,TMK-29', 'TMK', 'RMK-100,PMK-71,SMK-71,TMK-83', 'RMK'),
(50, 'Erode', 'Anthiyur', 329, 1155, 28, 'RMK-382,PMK-195,SMK-116,TMK-344', 'RMK', 126, 307, 'RMK-45,PMK-41,SMK-5,TMK-35', 'RMK', 'RMK-87,PMK-71,SMK-74,TMK-75', 'RMK'),
(205, 'Vellore', 'Arakkonam', 328, 1635, 20, 'RMK-270,PMK-276,SMK-471,TMK-456', 'SMK', 123, 293, 'RMK-14,PMK-20,SMK-47,TMK-42', 'SMK', 'RMK-70,PMK-88,SMK-66,TMK-69', 'PMK'),
(158, 'Thiruvannamalai', 'Arani', 367, 1318, 27, 'RMK-390,PMK-419,SMK-108,TMK-233', 'PMK', 124, 286, 'RMK-18,PMK-44,SMK-39,TMK-23', 'PMK', 'RMK-82,PMK-53,SMK-68,TMK-83', 'TMK'),
(110, 'Pudukkottai', 'Aranthangi', 387, 1418, 27, 'RMK-437,PMK-252,SMK-355,TMK-277', 'RMK', 96, 326, 'RMK-10,PMK-42,SMK-32,TMK-12', 'PMK', 'RMK-99,PMK-52,SMK-97,TMK-78', 'RMK'),
(75, 'Karur', 'Aravakurichi', 411, 1298, 31, 'RMK-191,PMK-133,SMK-351,TMK-478', 'TMK', 95, 290, 'RMK-27,PMK-38,SMK-6,TMK-24', 'PMK', 'RMK-94,PMK-55,SMK-89,TMK-52', 'RMK'),
(206, 'Vellore', 'Arcot', 287, 1316, 21, 'RMK-307,PMK-257,SMK-318,TMK-287', 'SMK', 123, 318, 'RMK-21,PMK-40,SMK-12,TMK-50', 'TMK', 'RMK-65,PMK-100,SMK-60,TMK-93', 'PMK'),
(1, 'Ariyalur', 'Ariyalur', 265, 1513, 17, 'RMK-240,PMK-440,SMK-462,TMK-189', 'SMK', 113, 311, 'RMK-21,PMK-38,SMK-29,TMK-25', 'PMK', 'RMK-92,PMK-94,SMK-62,TMK-63', 'PMK'),
(227, 'Virudhunagar', 'Aruppukottai', 308, 1208, 25, 'RMK-365,PMK-248,SMK-159,TMK-403', 'TMK', 142, 324, 'RMK-18,PMK-46,SMK-38,TMK-40', 'PMK', 'RMK-99,PMK-89,SMK-58,TMK-78', 'RMK'),
(43, 'Dindigul', 'Athoor', 274, 1201, 22, 'RMK-328,PMK-121,SMK-294,TMK-267', 'RMK', 78, 319, 'RMK-18,PMK-7,SMK-35,TMK-18', 'SMK', 'RMK-97,PMK-85,SMK-79,TMK-58', 'RMK'),
(119, 'Salem', 'Attur', 404, 1279, 31, 'RMK-286,PMK-316,SMK-164,TMK-378', 'TMK', 112, 295, 'RMK-48,PMK-18,SMK-13,TMK-33', 'RMK', 'RMK-62,PMK-78,SMK-94,TMK-61', 'SMK'),
(149, 'Thiruvallur', 'Avadi', 307, 1575, 19, 'RMK-285,PMK-353,SMK-241,TMK-496', 'TMK', 121, 319, 'RMK-44,PMK-26,SMK-17,TMK-34', 'RMK', 'RMK-75,PMK-79,SMK-89,TMK-76', 'SMK'),
(195, 'Tiruppur', 'Avanashi', 395, 1043, 37, 'RMK-430,PMK-190,SMK-207,TMK-104', 'RMK', 76, 300, 'RMK-37,PMK-18,SMK-7,TMK-14', 'RMK', 'RMK-94,PMK-69,SMK-57,TMK-80', 'RMK'),
(79, 'Krishnagiri', 'Bargur', 375, 1164, 32, 'RMK-279,PMK-195,SMK-334,TMK-249', 'SMK', 104, 299, 'RMK-34,PMK-6,SMK-25,TMK-39', 'TMK', 'RMK-70,PMK-52,SMK-81,TMK-96', 'TMK'),
(51, 'Erode', 'Bhavani', 346, 1436, 24, 'RMK-145,PMK-339,SMK-448,TMK-314', 'SMK', 99, 305, 'RMK-50,PMK-15,SMK-14,TMK-20', 'RMK', 'RMK-91,PMK-95,SMK-60,TMK-59', 'PMK'),
(52, 'Erode', 'Bhavanisagar', 263, 1362, 19, 'RMK-315,PMK-497,SMK-136,TMK-389', 'PMK', 129, 322, 'RMK-46,PMK-50,SMK-18,TMK-15', 'PMK', 'RMK-93,PMK-90,SMK-74,TMK-65', 'RMK'),
(29, 'Cuddalore', 'Bhuvanagiri', 275, 1805, 15, 'RMK-469,PMK-267,SMK-436,TMK-472', 'TMK', 91, 286, 'RMK-9,PMK-9,SMK-31,TMK-42', 'TMK', 'RMK-100,PMK-53,SMK-75,TMK-58', 'RMK'),
(145, 'Theni', 'Bodinayakanur', 372, 975, 38, 'RMK-133,PMK-193,SMK-256,TMK-362', 'TMK', 111, 287, 'RMK-22,PMK-21,SMK-29,TMK-39', 'TMK', 'RMK-61,PMK-76,SMK-54,TMK-96', 'TMK'),
(59, 'Kancheepuram', 'Chengalpattu', 436, 1420, 30, 'RMK-423,PMK-415,SMK-205,TMK-284', 'RMK', 132, 325, 'RMK-47,PMK-24,SMK-48,TMK-13', 'SMK', 'RMK-54,PMK-98,SMK-75,TMK-98', 'PMK'),
(159, 'Thiruvannamalai', 'Chengam', 311, 990, 31, 'RMK-315,PMK-208,SMK-234,TMK-105', 'RMK', 118, 323, 'RMK-7,PMK-40,SMK-25,TMK-46', 'TMK', 'RMK-82,PMK-80,SMK-64,TMK-97', 'TMK'),
(4, 'Chennai', 'Chepaul-Thiruvallikeni', 391, 1255, 31, 'RMK-118,PMK-464,SMK-181,TMK-391', 'PMK', 144, 262, 'RMK-36,PMK-46,SMK-38,TMK-24', 'PMK', 'RMK-60,PMK-76,SMK-66,TMK-60', 'PMK'),
(160, 'Thiruvannamalai', 'Cheyyar', 315, 1318, 23, 'RMK-177,PMK-153,SMK-451,TMK-343', 'SMK', 127, 339, 'RMK-43,PMK-16,SMK-27,TMK-41', 'RMK', 'RMK-94,PMK-96,SMK-86,TMK-63', 'PMK'),
(60, 'Kancheepuram', 'Cheyyur', 422, 1337, 31, 'RMK-256,PMK-431,SMK-275,TMK-274', 'PMK', 126, 291, 'RMK-37,PMK-15,SMK-34,TMK-40', 'TMK', 'RMK-84,PMK-62,SMK-81,TMK-64', 'RMK'),
(30, 'Cuddalore', 'Chidambaram', 468, 1728, 27, 'RMK-474,PMK-226,SMK-422,TMK-484', 'TMK', 121, 280, 'RMK-24,PMK-42,SMK-9,TMK-46', 'TMK', 'RMK-53,PMK-79,SMK-84,TMK-64', 'SMK'),
(19, 'Coimbatore', 'Coimbatore(North)', 371, 1065, 34, 'RMK-419,PMK-169,SMK-183,TMK-150', 'RMK', 104, 311, 'RMK-12,PMK-41,SMK-28,TMK-23', 'PMK', 'RMK-91,PMK-99,SMK-60,TMK-61', 'PMK'),
(20, 'Coimbatore', 'coimbatore(South)', 342, 1402, 24, 'RMK-498,PMK-312,SMK-303,TMK-128', 'RMK', 135, 314, 'RMK-46,PMK-24,SMK-23,TMK-42', 'RMK', 'RMK-67,PMK-82,SMK-87,TMK-78', 'SMK'),
(69, 'Kanniyakumari', 'Colachal', 305, 1806, 16, 'RMK-181,PMK-474,SMK-494,TMK-475', 'SMK', 90, 332, 'RMK-43,PMK-27,SMK-5,TMK-15', 'RMK', 'RMK-84,PMK-84,SMK-96,TMK-68', 'SMK'),
(141, 'The Nilgiris', 'Coonoor', 339, 1311, 25, 'RMK-379,PMK-286,SMK-387,TMK-162', 'SMK', 117, 348, 'RMK-32,PMK-30,SMK-7,TMK-48', 'TMK', 'RMK-91,PMK-93,SMK-81,TMK-83', 'PMK'),
(31, 'Cuddalore', 'Cuddalore', 414, 809, 51, 'RMK-205,PMK-171,SMK-178,TMK-237', 'TMK', 117, 264, 'RMK-41,PMK-22,SMK-22,TMK-32', 'RMK', 'RMK-86,PMK-58,SMK-62,TMK-58', 'RMK'),
(146, 'Theni', 'Cumbum', 267, 1116, 23, 'RMK-184,PMK-308,SMK-202,TMK-257', 'PMK', 116, 314, 'RMK-44,PMK-9,SMK-45,TMK-18', 'SMK', 'RMK-54,PMK-74,SMK-93,TMK-93', 'SMK'),
(196, 'Tiruppur', 'Dharapuram', 397, 1560, 25, 'RMK-138,PMK-432,SMK-499,TMK-470', 'SMK', 72, 328, 'RMK-17,PMK-30,SMK-16,TMK-9', 'PMK', 'RMK-83,PMK-89,SMK-61,TMK-95', 'TMK'),
(38, 'Dharmapuri', 'Dharmapuri', 349, 1383, 25, 'RMK-217,PMK-327,SMK-417,TMK-377', 'SMK', 138, 333, 'RMK-36,PMK-50,SMK-37,TMK-15', 'PMK', 'RMK-57,PMK-100,SMK-80,TMK-96', 'PMK'),
(44, 'Dindigul', 'Dindigul', 313, 738, 42, 'RMK-115,PMK-257,SMK-103,TMK-138', 'PMK', 93, 251, 'RMK-17,PMK-39,SMK-18,TMK-19', 'PMK', 'RMK-60,PMK-65,SMK-52,TMK-74', 'TMK'),
(5, 'Chennai', 'Dr.Radhakrishnan Nagar', 304, 1253, 24, 'RMK-122,PMK-378,SMK-334,TMK-267', 'PMK', 55, 299, 'RMK-32,PMK-5,SMK-5,TMK-13', 'RMK', 'RMK-53,PMK-91,SMK-65,TMK-90', 'PMK'),
(120, 'Salem', 'Edappadi', 295, 1393, 21, 'RMK-262,PMK-392,SMK-128,TMK-449', 'TMK', 77, 313, 'RMK-26,PMK-15,SMK-8,TMK-28', 'TMK', 'RMK-87,PMK-75,SMK-94,TMK-57', 'SMK'),
(6, 'Chennai', 'Egmore', 514, 1284, 40, 'RMK-377,PMK-486,SMK-198,TMK-165', 'PMK', 118, 291, 'RMK-17,PMK-30,SMK-44,TMK-27', 'SMK', 'RMK-88,PMK-55,SMK-77,TMK-71', 'RMK'),
(53, 'Erode', 'Erode(East)', 347, 1638, 21, 'RMK-188,PMK-414,SMK-497,TMK-343', 'SMK', 131, 254, 'RMK-42,PMK-27,SMK-38,TMK-24', 'RMK', 'RMK-58,PMK-54,SMK-83,TMK-59', 'SMK'),
(54, 'Erode', 'Erode(West)', 434, 1107, 39, 'RMK-200,PMK-160,SMK-288,TMK-295', 'TMK', 118, 321, 'RMK-24,PMK-21,SMK-23,TMK-50', 'TMK', 'RMK-87,PMK-73,SMK-88,TMK-73', 'SMK'),
(111, 'Pudukkottai', 'Gandharvakottai', 311, 1449, 21, 'RMK-493,PMK-241,SMK-219,TMK-400', 'RMK', 113, 319, 'RMK-23,PMK-46,SMK-38,TMK-6', 'PMK', 'RMK-76,PMK-65,SMK-88,TMK-90', 'TMK'),
(121, 'Salem', 'Gangavalli', 358, 1459, 24, 'RMK-245,PMK-300,SMK-420,TMK-366', 'SMK', 132, 379, 'RMK-25,PMK-15,SMK-44,TMK-48', 'TMK', 'RMK-93,PMK-88,SMK-98,TMK-100', 'TMK'),
(216, 'Villupuram', 'Gingee', 388, 1577, 24, 'RMK-260,PMK-429,SMK-495,TMK-336', 'SMK', 100, 356, 'RMK-12,PMK-36,SMK-35,TMK-17', 'PMK', 'RMK-95,PMK-88,SMK-87,TMK-86', 'RMK'),
(55, 'Erode', 'Gobichettipalayam', 384, 1071, 35, 'RMK-105,PMK-291,SMK-250,TMK-277', 'PMK', 104, 291, 'RMK-15,PMK-44,SMK-10,TMK-35', 'PMK', 'RMK-55,PMK-90,SMK-75,TMK-71', 'PMK'),
(142, 'The Nilgiris', 'Gudalur', 444, 1126, 39, 'RMK-165,PMK-469,SMK-209,TMK-108', 'PMK', 141, 223, 'RMK-30,PMK-23,SMK-47,TMK-41', 'SMK', 'RMK-53,PMK-58,SMK-58,TMK-54', 'PMK'),
(207, 'Vellore', 'Gudiyattam', 306, 1457, 21, 'RMK-210,PMK-307,SMK-369,TMK-416', 'TMK', 120, 306, 'RMK-42,PMK-28,SMK-31,TMK-19', 'RMK', 'RMK-61,PMK-54,SMK-91,TMK-100', 'TMK'),
(150, 'Thiruvallur', 'Gummidipoondi', 390, 1115, 34, 'RMK-368,PMK-290,SMK-236,TMK-207', 'RMK', 141, 235, 'RMK-27,PMK-48,SMK-29,TMK-37', 'PMK', 'RMK-64,PMK-52,SMK-66,TMK-53', 'SMK'),
(7, 'Chennai', 'Harbour', 293, 1241, 23, 'RMK-125,PMK-409,SMK-208,TMK-354', 'PMK', 133, 311, 'RMK-18,PMK-39,SMK-41,TMK-35', 'SMK', 'RMK-80,PMK-82,SMK-60,TMK-89', 'TMK'),
(39, 'Dharmapuri', 'Harur', 364, 1163, 31, 'RMK-419,PMK-160,SMK-136,TMK-363', 'RMK', 117, 359, 'RMK-45,PMK-8,SMK-44,TMK-20', 'RMK', 'RMK-99,PMK-77,SMK-98,TMK-85', 'RMK'),
(80, 'Krishnagiri', 'Hosur', 371, 1720, 21, 'RMK-458,PMK-445,SMK-333,TMK-352', 'RMK', 107, 324, 'RMK-26,PMK-19,SMK-20,TMK-42', 'TMK', 'RMK-100,PMK-83,SMK-78,TMK-63', 'RMK'),
(2, 'Ariyalur', 'Jayankondam', 307, 1321, 23, 'RMK-351,PMK-185,SMK-459,TMK-243', 'SMK', 78, 273, 'RMK-30,PMK-21,SMK-21,TMK-6', 'RMK', 'RMK-82,PMK-56,SMK-52,TMK-83', 'TMK'),
(208, 'Vellore', 'Jolarpet', 296, 1611, 18, 'RMK-349,PMK-351,SMK-350,TMK-460', 'TMK', 143, 241, 'RMK-29,PMK-39,SMK-26,TMK-49', 'TMK', 'RMK-61,PMK-67,SMK-55,TMK-58', 'PMK'),
(187, 'Tirunelveli', 'Kadayanallur', 391, 960, 40, 'RMK-189,PMK-205,SMK-238,TMK-152', 'SMK', 144, 310, 'RMK-44,PMK-40,SMK-18,TMK-42', 'RMK', 'RMK-69,PMK-70,SMK-75,TMK-96', 'TMK'),
(161, 'Thiruvannamalai', 'Kalasapakkam', 325, 1590, 20, 'RMK-177,PMK-451,SMK-400,TMK-413', 'PMK', 123, 290, 'RMK-49,PMK-12,SMK-49,TMK-13', 'RMK', 'RMK-97,PMK-78,SMK-58,TMK-57', 'RMK'),
(217, 'Villupuram', 'Kallakurichi', 259, 1165, 22, 'RMK-245,PMK-101,SMK-499,TMK-131', 'SMK', 99, 354, 'RMK-30,PMK-28,SMK-30,TMK-11', 'RMK', 'RMK-91,PMK-88,SMK-99,TMK-76', 'SMK'),
(61, 'Kancheepuram', 'Kancheepuram', 449, 1070, 41, 'RMK-261,PMK-154,SMK-263,TMK-334', 'TMK', 70, 335, 'RMK-15,PMK-7,SMK-41,TMK-7', 'SMK', 'RMK-72,PMK-87,SMK-95,TMK-81', 'SMK'),
(197, 'Tiruppur', 'Kangayam', 357, 1251, 28, 'RMK-216,PMK-490,SMK-151,TMK-262', 'PMK', 130, 303, 'RMK-25,PMK-42,SMK-23,TMK-40', 'PMK', 'RMK-91,PMK-61,SMK-81,TMK-70', 'RMK'),
(70, 'Kanniyakumari', 'Kanniyakumari', 347, 1507, 23, 'RMK-355,PMK-261,SMK-456,TMK-235', 'SMK', 106, 263, 'RMK-25,PMK-5,SMK-44,TMK-32', 'SMK', 'RMK-64,PMK-71,SMK-55,TMK-73', 'TMK'),
(130, 'Sivagangai', 'Karaikudi', 358, 1123, 31, 'RMK-289,PMK-225,SMK-294,TMK-159', 'SMK', 76, 256, 'RMK-15,PMK-29,SMK-11,TMK-21', 'PMK', 'RMK-59,PMK-57,SMK-86,TMK-54', 'SMK'),
(76, 'Karur', 'Karur', 404, 1410, 28, 'RMK-351,PMK-458,SMK-134,TMK-314', 'PMK', 127, 299, 'RMK-17,PMK-23,SMK-42,TMK-45', 'TMK', 'RMK-60,PMK-59,SMK-92,TMK-88', 'SMK'),
(209, 'Vellore', 'Katpadi', 417, 1245, 33, 'RMK-236,PMK-301,SMK-113,TMK-480', 'TMK', 84, 321, 'RMK-11,PMK-7,SMK-47,TMK-19', 'SMK', 'RMK-71,PMK-98,SMK-82,TMK-70', 'PMK'),
(32, 'Cuddalore', 'Kattumannarkoil', 368, 1423, 25, 'RMK-178,PMK-416,SMK-189,TMK-457', 'TMK', 127, 296, 'RMK-27,PMK-18,SMK-41,TMK-41', 'SMK', 'RMK-85,PMK-65,SMK-67,TMK-79', 'RMK'),
(21, 'Coimbatore', 'Kavundampalayam', 480, 1161, 41, 'RMK-118,PMK-146,SMK-383,TMK-415', 'TMK', 148, 312, 'RMK-40,PMK-49,SMK-30,TMK-29', 'PMK', 'RMK-78,PMK-100,SMK-69,TMK-65', 'PMK'),
(71, 'Kanniyakumari', 'Killiyoor', 296, 1137, 26, 'RMK-105,PMK-497,SMK-352,TMK-136', 'PMK', 112, 340, 'RMK-49,PMK-5,SMK-12,TMK-46', 'RMK', 'RMK-99,PMK-75,SMK-82,TMK-84', 'RMK'),
(162, 'Thiruvannamalai', 'Kilpennathur', 326, 1261, 25, 'RMK-186,PMK-328,SMK-162,TMK-395', 'TMK', 103, 298, 'RMK-44,PMK-43,SMK-9,TMK-7', 'RMK', 'RMK-89,PMK-56,SMK-72,TMK-81', 'RMK'),
(210, 'Vellore', 'Kilvaithinankuppam', 406, 1382, 29, 'RMK-236,PMK-450,SMK-288,TMK-315', 'PMK', 36, 297, 'RMK-13,PMK-5,SMK-13,TMK-5', 'RMK', 'RMK-73,PMK-90,SMK-68,TMK-66', 'PMK'),
(95, 'Nagapattinam', 'Kilvelur', 335, 1546, 21, 'RMK-373,PMK-451,SMK-301,TMK-385', 'PMK', 184, 302, 'RMK-47,PMK-48,SMK-39,TMK-50', 'TMK', 'RMK-64,PMK-78,SMK-76,TMK-84', 'TMK'),
(22, 'Coimbatore', 'Kinathukadavu', 259, 1033, 25, 'RMK-413,PMK-110,SMK-303,TMK-140', 'RMK', 100, 315, 'RMK-13,PMK-32,SMK-46,TMK-9', 'SMK', 'RMK-87,PMK-54,SMK-75,TMK-99', 'TMK'),
(8, 'Chennai', 'Kolathur', 321, 925, 34, 'RMK-204,PMK-257,SMK-135,TMK-192', 'PMK', 54, 310, 'RMK-9,PMK-5,SMK-32,TMK-8', 'SMK', 'RMK-98,PMK-81,SMK-67,TMK-64', 'RMK'),
(170, 'Thoothukudi', 'Kovilpatti', 394, 1122, 35, 'RMK-114,PMK-102,SMK-439,TMK-448', 'TMK', 134, 271, 'RMK-11,PMK-33,SMK-42,TMK-48', 'TMK', 'RMK-62,PMK-100,SMK-56,TMK-53', 'PMK'),
(81, 'Krishnagiri', 'Krishnagiri', 367, 1041, 35, 'RMK-289,PMK-326,SMK-188,TMK-158', 'PMK', 98, 259, 'RMK-45,PMK-6,SMK-16,TMK-31', 'RMK', 'RMK-61,PMK-76,SMK-63,TMK-59', 'PMK'),
(77, 'Karur', 'Krishnarayapuram', 356, 1396, 25, 'RMK-359,PMK-136,SMK-375,TMK-462', 'TMK', 119, 329, 'RMK-16,PMK-21,SMK-34,TMK-48', 'TMK', 'RMK-99,PMK-86,SMK-57,TMK-87', 'RMK'),
(78, 'Karur', 'Kulithalai', 316, 1356, 23, 'RMK-228,PMK-376,SMK-471,TMK-261', 'SMK', 175, 293, 'RMK-43,PMK-47,SMK-36,TMK-49', 'TMK', 'RMK-80,PMK-99,SMK-59,TMK-55', 'PMK'),
(101, 'Namakkal', 'Kumarapalayam', 432, 1279, 33, 'RMK-402,PMK-110,SMK-129,TMK-492', 'TMK', 84, 276, 'RMK-24,PMK-10,SMK-7,TMK-43', 'TMK', 'RMK-64,PMK-77,SMK-54,TMK-81', 'TMK'),
(134, 'Thanjavur', 'Kumbakonam', 445, 1324, 33, 'RMK-104,PMK-360,SMK-381,TMK-421', 'TMK', 127, 262, 'RMK-23,PMK-20,SMK-49,TMK-35', 'SMK', 'RMK-84,PMK-56,SMK-59,TMK-63', 'RMK'),
(107, 'Perambalur', 'Kunnam', 395, 1615, 24, 'RMK-434,PMK-411,SMK-356,TMK-238', 'RMK', 63, 337, 'RMK-6,PMK-7,SMK-26,TMK-24', 'SMK', 'RMK-81,PMK-89,SMK-89,TMK-78', 'PMK'),
(33, 'Cuddalore', 'Kurinjipadi', 305, 1551, 19, 'RMK-394,PMK-372,SMK-204,TMK-389', 'RMK', 101, 276, 'RMK-30,PMK-23,SMK-6,TMK-42', 'TMK', 'RMK-88,PMK-56,SMK-67,TMK-65', 'RMK'),
(176, 'Tiruchirappalli', 'Lalgudi', 365, 1209, 30, 'RMK-285,PMK-211,SMK-247,TMK-285', 'RMK', 142, 267, 'RMK-34,PMK-47,SMK-39,TMK-22', 'PMK', 'RMK-65,PMK-73,SMK-61,TMK-68', 'PMK'),
(198, 'Tiruppur', 'Madathukulam', 363, 1156, 31, 'RMK-257,PMK-139,SMK-216,TMK-461', 'TMK', 92, 295, 'RMK-35,PMK-26,SMK-23,TMK-8', 'RMK', 'RMK-77,PMK-53,SMK-70,TMK-95', 'TMK'),
(151, 'Thiruvallur', 'Madavaram', 272, 996, 27, 'RMK-122,PMK-172,SMK-232,TMK-408', 'TMK', 186, 249, 'RMK-43,PMK-44,SMK-50,TMK-49', 'SMK', 'RMK-59,PMK-55,SMK-58,TMK-77', 'TMK'),
(85, 'Madurai', 'Madurai Central', 282, 858, 32, 'RMK-241,PMK-132,SMK-175,TMK-163', 'RMK', 116, 290, 'RMK-12,PMK-42,SMK-46,TMK-16', 'SMK', 'RMK-52,PMK-77,SMK-81,TMK-80', 'SMK'),
(86, 'Madurai', 'Madurai East', 297, 1360, 21, 'RMK-351,PMK-343,SMK-280,TMK-266', 'RMK', 109, 300, 'RMK-46,PMK-6,SMK-16,TMK-41', 'RMK', 'RMK-75,PMK-70,SMK-100,TMK-55', 'SMK'),
(87, 'Madurai', 'Madurai North', 320, 1206, 26, 'RMK-183,PMK-253,SMK-432,TMK-164', 'SMK', 88, 288, 'RMK-22,PMK-27,SMK-28,TMK-11', 'SMK', 'RMK-57,PMK-79,SMK-74,TMK-78', 'PMK'),
(88, 'Madurai', 'Madurai South', 443, 1123, 39, 'RMK-314,PMK-458,SMK-193,TMK-107', 'PMK', 108, 269, 'RMK-30,PMK-29,SMK-18,TMK-31', 'TMK', 'RMK-80,PMK-52,SMK-74,TMK-63', 'RMK'),
(89, 'Madurai', 'Madurai West', 408, 885, 46, 'RMK-306,PMK-145,SMK-220,TMK-170', 'RMK', 87, 268, 'RMK-13,PMK-50,SMK-5,TMK-19', 'PMK', 'RMK-77,PMK-60,SMK-69,TMK-62', 'RMK'),
(62, 'Kancheepuram', 'Madurantakam', 320, 1066, 30, 'RMK-189,PMK-242,SMK-315,TMK-270', 'SMK', 151, 283, 'RMK-40,PMK-47,SMK-22,TMK-42', 'PMK', 'RMK-81,PMK-71,SMK-70,TMK-61', 'RMK'),
(152, 'Thiruvallur', 'Maduravoyal', 349, 1457, 23, 'RMK-321,PMK-288,SMK-365,TMK-422', 'TMK', 125, 271, 'RMK-42,PMK-5,SMK-40,TMK-38', 'RMK', 'RMK-66,PMK-69,SMK-76,TMK-60', 'SMK'),
(218, 'Villupuram', 'Mailam', 400, 1285, 31, 'RMK-495,PMK-105,SMK-225,TMK-276', 'RMK', 128, 304, 'RMK-27,PMK-16,SMK-49,TMK-36', 'SMK', 'RMK-68,PMK-71,SMK-73,TMK-92', 'TMK'),
(131, 'Sivagangai', 'Manamadurai', 270, 1341, 20, 'RMK-126,PMK-299,SMK-377,TMK-399', 'TMK', 110, 340, 'RMK-31,PMK-16,SMK-29,TMK-34', 'TMK', 'RMK-92,PMK-79,SMK-74,TMK-95', 'TMK'),
(178, 'Tiruchirappalli', 'Manapparai', 368, 1367, 26, 'RMK-386,PMK-247,SMK-240,TMK-336', 'RMK', 113, 321, 'RMK-21,PMK-30,SMK-27,TMK-35', 'TMK', 'RMK-94,PMK-56,SMK-95,TMK-76', 'SMK'),
(177, 'Tiruchirappalli', 'Mannachanallur', 406, 1359, 29, 'RMK-108,PMK-432,SMK-355,TMK-319', 'PMK', 69, 275, 'RMK-35,PMK-10,SMK-11,TMK-13', 'RMK', 'RMK-70,PMK-84,SMK-56,TMK-65', 'PMK'),
(166, 'Thiruvarur', 'Mannargudi', 445, 1096, 40, 'RMK-354,PMK-152,SMK-114,TMK-450', 'TMK', 96, 308, 'RMK-28,PMK-40,SMK-9,TMK-19', 'PMK', 'RMK-70,PMK-80,SMK-66,TMK-92', 'TMK'),
(96, 'Nagapattinam', 'Mayiladuthurai', 186, 1264, 14, 'RMK-240,PMK-279,SMK-484,TMK-236', 'SMK', 101, 286, 'RMK-41,PMK-27,SMK-15,TMK-18', 'RMK', 'RMK-53,PMK-81,SMK-62,TMK-90', 'TMK'),
(90, 'Madurai', 'Mellur', 459, 1217, 37, 'RMK-128,PMK-495,SMK-142,TMK-302', 'PMK', 70, 319, 'RMK-17,PMK-23,SMK-24,TMK-6', 'SMK', 'RMK-99,PMK-80,SMK-72,TMK-68', 'RMK'),
(23, 'Coimbatore', 'Mettuppalayam', 282, 1289, 21, 'RMK-383,PMK-271,SMK-136,TMK-343', 'RMK', 63, 284, 'RMK-10,PMK-24,SMK-9,TMK-20', 'PMK', 'RMK-63,PMK-60,SMK-69,TMK-92', 'TMK'),
(122, 'Salem', 'Mettur', 383, 1220, 31, 'RMK-177,PMK-235,SMK-251,TMK-366', 'TMK', 129, 290, 'RMK-48,PMK-18,SMK-18,TMK-45', 'RMK', 'RMK-62,PMK-70,SMK-89,TMK-69', 'SMK'),
(56, 'Erode', 'Modakkurichi', 314, 1349, 23, 'RMK-184,PMK-375,SMK-176,TMK-469', 'TMK', 111, 340, 'RMK-42,PMK-5,SMK-19,TMK-45', 'TMK', 'RMK-88,PMK-91,SMK-76,TMK-85', 'PMK'),
(115, 'Ramanathapuram', 'Mudhukulathur', 362, 1061, 34, 'RMK-405,PMK-122,SMK-309,TMK-204', 'RMK', 97, 286, 'RMK-31,PMK-24,SMK-29,TMK-13', 'RMK', 'RMK-58,PMK-73,SMK-75,TMK-80', 'TMK'),
(179, 'Tiruchirappalli', 'Musiri', 419, 1520, 27, 'RMK-180,PMK-394,SMK-450,TMK-382', 'SMK', 114, 277, 'RMK-48,PMK-5,SMK-32,TMK-29', 'RMK', 'RMK-61,PMK-59,SMK-94,TMK-63', 'SMK'),
(9, 'Chennai', 'Mylapore', 357, 1483, 24, 'RMK-453,PMK-193,SMK-421,TMK-363', 'RMK', 120, 254, 'RMK-34,PMK-30,SMK-34,TMK-22', 'RMK', 'RMK-90,PMK-60,SMK-53,TMK-51', 'RMK'),
(97, 'Nagapattinam', 'Nagapattinam', 408, 1835, 22, 'RMK-496,PMK-272,SMK-493,TMK-486', 'RMK', 100, 281, 'RMK-10,PMK-35,SMK-27,TMK-28', 'PMK', 'RMK-53,PMK-56,SMK-83,TMK-89', 'TMK'),
(72, 'Kanniyakumari', 'Nagercoil', 340, 1632, 20, 'RMK-402,PMK-470,SMK-429,TMK-280', 'PMK', 128, 276, 'RMK-45,PMK-8,SMK-34,TMK-41', 'RMK', 'RMK-55,PMK-90,SMK-52,TMK-79', 'PMK'),
(102, 'Namakkal', 'Namakkal', 367, 1213, 30, 'RMK-341,PMK-388,SMK-230,TMK-123', 'PMK', 88, 288, 'RMK-20,PMK-25,SMK-11,TMK-32', 'TMK', 'RMK-57,PMK-66,SMK-87,TMK-78', 'SMK'),
(188, 'Tirunelveli', 'Nanguneri', 339, 1157, 29, 'RMK-268,PMK-463,SMK-212,TMK-178', 'PMK', 143, 360, 'RMK-48,PMK-39,SMK-39,TMK-17', 'RMK', 'RMK-79,PMK-92,SMK-94,TMK-95', 'TMK'),
(167, 'Thiruvarur', 'Nannilam', 380, 1228, 30, 'RMK-313,PMK-259,SMK-271,TMK-273', 'RMK', 167, 293, 'RMK-35,PMK-42,SMK-50,TMK-40', 'SMK', 'RMK-78,PMK-51,SMK-75,TMK-89', 'TMK'),
(45, 'Dindigul', 'Natham', 321, 1178, 27, 'RMK-307,PMK-271,SMK-388,TMK-168', 'SMK', 57, 247, 'RMK-17,PMK-21,SMK-10,TMK-9', 'PMK', 'RMK-54,PMK-59,SMK-78,TMK-56', 'SMK'),
(34, 'Cuddalore', 'Neyveli', 402, 1245, 32, 'RMK-300,PMK-441,SMK-216,TMK-254', 'PMK', 132, 295, 'RMK-5,PMK-45,SMK-35,TMK-47', 'TMK', 'RMK-68,PMK-92,SMK-76,TMK-59', 'PMK'),
(46, 'Dindigul', 'Nilakkottai', 386, 1036, 37, 'RMK-111,PMK-481,SMK-211,TMK-148', 'PMK', 134, 309, 'RMK-37,PMK-32,SMK-36,TMK-29', 'RMK', 'RMK-77,PMK-81,SMK-72,TMK-79', 'PMK'),
(47, 'Dindigul', 'Oddanchatram', 467, 1352, 34, 'RMK-173,PMK-424,SMK-149,TMK-420', 'PMK', 130, 303, 'RMK-46,PMK-17,SMK-29,TMK-38', 'RMK', 'RMK-66,PMK-73,SMK-69,TMK-95', 'TMK'),
(123, 'Salem', 'Omalur', 406, 1044, 38, 'RMK-109,PMK-466,SMK-275,TMK-105', 'PMK', 142, 353, 'RMK-21,PMK-38,SMK-42,TMK-41', 'SMK', 'RMK-88,PMK-86,SMK-100,TMK-79', 'SMK'),
(135, 'Thanjavur', 'Orathanadu', 318, 1371, 23, 'RMK-496,PMK-139,SMK-145,TMK-463', 'RMK', 110, 281, 'RMK-13,PMK-44,SMK-34,TMK-19', 'PMK', 'RMK-85,PMK-73,SMK-67,TMK-56', 'RMK'),
(171, 'Thoothukudi', 'Ottapidaram', 390, 1427, 27, 'RMK-269,PMK-286,SMK-408,TMK-412', 'TMK', 79, 263, 'RMK-17,PMK-20,SMK-8,TMK-34', 'TMK', 'RMK-57,PMK-72,SMK-75,TMK-59', 'SMK'),
(73, 'Kanniyakumari', 'Padmanabhapuram', 341, 1130, 30, 'RMK-415,PMK-254,SMK-164,TMK-112', 'RMK', 90, 346, 'RMK-42,PMK-24,SMK-19,TMK-5', 'RMK', 'RMK-98,PMK-97,SMK-57,TMK-94', 'RMK'),
(40, 'Dharmapuri', 'Palacodu', 283, 1269, 22, 'RMK-395,PMK-190,SMK-376,TMK-129', 'RMK', 42, 352, 'RMK-14,PMK-11,SMK-6,TMK-11', 'RMK', 'RMK-69,PMK-100,SMK-92,TMK-91', 'PMK'),
(48, 'Dindigul', 'Palani', 393, 1478, 26, 'RMK-366,PMK-472,SMK-355,TMK-236', 'PMK', 75, 327, 'RMK-32,PMK-27,SMK-6,TMK-10', 'RMK', 'RMK-77,PMK-70,SMK-89,TMK-91', 'TMK'),
(189, 'Tirunelveli', 'Palayamkottai', 407, 908, 44, 'RMK-429,PMK-115,SMK-186,TMK-105', 'RMK', 139, 272, 'RMK-25,PMK-35,SMK-50,TMK-29', 'SMK', 'RMK-67,PMK-80,SMK-62,TMK-63', 'PMK'),
(199, 'Tiruppur', 'Palladam', 484, 1179, 41, 'RMK-373,PMK-236,SMK-152,TMK-339', 'RMK', 98, 301, 'RMK-46,PMK-8,SMK-8,TMK-36', 'RMK', 'RMK-78,PMK-70,SMK-57,TMK-96', 'TMK'),
(63, 'Kancheepuram', 'Pallavaram', 294, 1616, 18, 'RMK-351,PMK-384,SMK-380,TMK-478', 'TMK', 110, 251, 'RMK-25,PMK-8,SMK-34,TMK-43', 'TMK', 'RMK-84,PMK-57,SMK-52,TMK-58', 'RMK'),
(35, 'Cuddalore', 'Panruti', 339, 1317, 25, 'RMK-348,PMK-225,SMK-182,TMK-462', 'TMK', 80, 311, 'RMK-25,PMK-21,SMK-20,TMK-14', 'RMK', 'RMK-84,PMK-68,SMK-96,TMK-63', 'SMK'),
(136, 'Thanjavur', 'Papanasam', 333, 1582, 21, 'RMK-479,PMK-407,SMK-337,TMK-167', 'RMK', 117, 347, 'RMK-33,PMK-42,SMK-5,TMK-37', 'PMK', 'RMK-82,PMK-99,SMK-69,TMK-97', 'PMK'),
(41, 'Dharmapuri', 'Pappireddippatti', 404, 1209, 33, 'RMK-387,PMK-258,SMK-153,TMK-286', 'RMK', 67, 302, 'RMK-8,PMK-31,SMK-7,TMK-21', 'PMK', 'RMK-87,PMK-66,SMK-61,TMK-88', 'TMK'),
(116, 'Ramanathapuram', 'Paramakudi', 370, 1097, 33, 'RMK-166,PMK-182,SMK-174,TMK-388', 'TMK', 97, 303, 'RMK-11,PMK-27,SMK-50,TMK-9', 'SMK', 'RMK-93,PMK-85,SMK-53,TMK-72', 'RMK'),
(103, 'Namakkal', 'Paramathi-Velur', 353, 1367, 25, 'RMK-278,PMK-388,SMK-365,TMK-227', 'PMK', 131, 321, 'RMK-26,PMK-32,SMK-28,TMK-45', 'TMK', 'RMK-76,PMK-80,SMK-69,TMK-96', 'TMK'),
(137, 'Thanjavur', 'Pattukkottai', 303, 846, 35, 'RMK-106,PMK-197,SMK-246,TMK-135', 'SMK', 87, 343, 'RMK-33,PMK-28,SMK-16,TMK-10', 'RMK', 'RMK-100,PMK-94,SMK-59,TMK-90', 'RMK'),
(42, 'Dharmapuri', 'Pennagaram', 420, 1247, 33, 'RMK-194,PMK-407,SMK-403,TMK-141', 'PMK', 142, 327, 'RMK-43,PMK-41,SMK-47,TMK-11', 'SMK', 'RMK-78,PMK-83,SMK-86,TMK-80', 'SMK'),
(108, 'Perambalur', 'Perambalur', 367, 1282, 28, 'RMK-228,PMK-123,SMK-245,TMK-497', 'TMK', 173, 318, 'RMK-46,PMK-45,SMK-47,TMK-35', 'SMK', 'RMK-81,PMK-90,SMK-95,TMK-52', 'SMK'),
(10, 'Chennai', 'Perambur', 389, 1193, 32, 'RMK-196,PMK-145,SMK-241,TMK-421', 'TMK', 93, 333, 'RMK-44,PMK-39,SMK-5,TMK-5', 'RMK', 'RMK-93,PMK-90,SMK-63,TMK-87', 'RMK'),
(138, 'Thanjavur', 'Peravurani', 452, 1195, 37, 'RMK-399,PMK-324,SMK-301,TMK-145', 'RMK', 124, 315, 'RMK-41,PMK-49,SMK-19,TMK-15', 'PMK', 'RMK-94,PMK-59,SMK-65,TMK-97', 'TMK'),
(147, 'Theni', 'Periyakulam', 444, 810, 54, 'RMK-132,PMK-170,SMK-139,TMK-294', 'TMK', 98, 308, 'RMK-12,PMK-7,SMK-47,TMK-32', 'SMK', 'RMK-81,PMK-95,SMK-74,TMK-58', 'PMK'),
(57, 'Erode', 'Perundurai', 381, 1414, 26, 'RMK-323,PMK-146,SMK-481,TMK-443', 'SMK', 132, 251, 'RMK-42,PMK-14,SMK-39,TMK-37', 'RMK', 'RMK-61,PMK-51,SMK-51,TMK-88', 'TMK'),
(24, 'Coimbatore', 'Pollachi', 402, 1269, 31, 'RMK-338,PMK-488,SMK-147,TMK-128', 'PMK', 158, 230, 'RMK-20,PMK-48,SMK-42,TMK-48', 'PMK', 'RMK-53,PMK-60,SMK-56,TMK-61', 'TMK'),
(163, 'Thiruvannamalai', 'Polur', 353, 1004, 35, 'RMK-243,PMK-225,SMK-289,TMK-136', 'SMK', 118, 321, 'RMK-50,PMK-45,SMK-17,TMK-6', 'RMK', 'RMK-62,PMK-61,SMK-100,TMK-98', 'SMK'),
(153, 'Thiruvallur', 'Ponneri', 474, 1320, 35, 'RMK-338,PMK-438,SMK-400,TMK-129', 'PMK', 124, 328, 'RMK-28,PMK-13,SMK-40,TMK-43', 'TMK', 'RMK-52,PMK-100,SMK-93,TMK-83', 'PMK'),
(98, 'Nagapattinam', 'Poompuhar', 424, 1613, 26, 'RMK-439,PMK-386,SMK-169,TMK-463', 'TMK', 144, 306, 'RMK-27,PMK-46,SMK-21,TMK-50', 'TMK', 'RMK-67,PMK-73,SMK-68,TMK-98', 'TMK'),
(154, 'Thiruvallur', 'Poonmallae', 346, 1160, 29, 'RMK-342,PMK-200,SMK-221,TMK-238', 'RMK', 102, 292, 'RMK-12,PMK-39,SMK-23,TMK-28', 'PMK', 'RMK-98,PMK-75,SMK-54,TMK-65', 'RMK'),
(112, 'Pudukkottai', 'Pudukkottai', 303, 1189, 25, 'RMK-327,PMK-339,SMK-199,TMK-245', 'PMK', 144, 366, 'RMK-29,PMK-27,SMK-38,TMK-50', 'TMK', 'RMK-78,PMK-91,SMK-100,TMK-97', 'SMK'),
(190, 'Tirunelveli', 'Radhapuram', 424, 1680, 25, 'RMK-349,PMK-293,SMK-423,TMK-436', 'TMK', 135, 317, 'RMK-43,PMK-31,SMK-36,TMK-25', 'RMK', 'RMK-69,PMK-72,SMK-84,TMK-92', 'TMK'),
(228, 'Virudhunagar', 'Rajapalayam', 353, 1350, 26, 'RMK-363,PMK-382,SMK-397,TMK-194', 'SMK', 146, 293, 'RMK-50,PMK-50,SMK-8,TMK-38', 'RMK', 'RMK-62,PMK-85,SMK-71,TMK-75', 'PMK'),
(117, 'Ramanathapuram', 'Ramanathapuram', 339, 1534, 22, 'RMK-445,PMK-271,SMK-402,TMK-238', 'RMK', 66, 352, 'RMK-5,PMK-17,SMK-37,TMK-7', 'SMK', 'RMK-95,PMK-97,SMK-86,TMK-74', 'PMK'),
(211, 'Vellore', 'Ranipet', 274, 1130, 24, 'RMK-339,PMK-100,SMK-217,TMK-409', 'TMK', 93, 307, 'RMK-17,PMK-29,SMK-41,TMK-6', 'SMK', 'RMK-91,PMK-68,SMK-74,TMK-74', 'RMK'),
(104, 'Namakkal', 'Rasipuram', 367, 1331, 27, 'RMK-303,PMK-227,SMK-445,TMK-201', 'SMK', 90, 306, 'RMK-34,PMK-5,SMK-23,TMK-28', 'RMK', 'RMK-88,PMK-59,SMK-65,TMK-94', 'TMK'),
(219, 'Villupuram', 'Rishivandiyam', 344, 1550, 22, 'RMK-484,PMK-270,SMK-453,TMK-275', 'RMK', 164, 315, 'RMK-47,PMK-46,SMK-39,TMK-32', 'RMK', 'RMK-80,PMK-92,SMK-58,TMK-85', 'PMK'),
(11, 'Chennai', 'Rouapuram', 253, 1363, 18, 'RMK-284,PMK-289,SMK-425,TMK-215', 'SMK', 59, 291, 'RMK-9,PMK-10,SMK-16,TMK-24', 'TMK', 'RMK-86,PMK-61,SMK-58,TMK-86', 'RMK'),
(12, 'Chennai', 'Saidapet', 327, 1326, 24, 'RMK-165,PMK-350,SMK-332,TMK-366', 'TMK', 85, 300, 'RMK-30,PMK-13,SMK-6,TMK-36', 'TMK', 'RMK-73,PMK-83,SMK-60,TMK-84', 'TMK'),
(124, 'Salem', 'Salem(North)', 300, 775, 38, 'RMK-137,PMK-125,SMK-102,TMK-212', 'TMK', 133, 326, 'RMK-44,PMK-46,SMK-9,TMK-34', 'PMK', 'RMK-88,PMK-85,SMK-77,TMK-76', 'RMK'),
(125, 'Salem', 'Salem(South)', 492, 1262, 38, 'RMK-188,PMK-389,SMK-223,TMK-343', 'PMK', 137, 279, 'RMK-23,PMK-32,SMK-37,TMK-45', 'TMK', 'RMK-82,PMK-75,SMK-52,TMK-70', 'RMK'),
(126, 'Salem', 'Salem(West)', 285, 1716, 16, 'RMK-499,PMK-441,SMK-227,TMK-458', 'RMK', 132, 339, 'RMK-13,PMK-21,SMK-48,TMK-50', 'TMK', 'RMK-90,PMK-79,SMK-97,TMK-73', 'SMK'),
(191, 'Tirunelveli', 'Sankarankovil', 272, 1367, 19, 'RMK-294,PMK-122,SMK-330,TMK-454', 'TMK', 103, 251, 'RMK-15,PMK-13,SMK-30,TMK-45', 'TMK', 'RMK-74,PMK-53,SMK-68,TMK-56', 'RMK'),
(220, 'Villupuram', 'Sankarapuram', 379, 1649, 22, 'RMK-390,PMK-476,SMK-436,TMK-257', 'PMK', 133, 361, 'RMK-49,PMK-6,SMK-30,TMK-48', 'RMK', 'RMK-74,PMK-98,SMK-89,TMK-100', 'TMK'),
(127, 'Salem', 'Sankari', 328, 1237, 26, 'RMK-263,PMK-476,SMK-195,TMK-235', 'PMK', 138, 294, 'RMK-50,PMK-31,SMK-41,TMK-16', 'RMK', 'RMK-56,PMK-87,SMK-52,TMK-99', 'TMK'),
(229, 'Virudhunagar', 'Sattur', 309, 1353, 22, 'RMK-324,PMK-312,SMK-349,TMK-252', 'SMK', 104, 328, 'RMK-25,PMK-32,SMK-18,TMK-29', 'PMK', 'RMK-97,PMK-86,SMK-60,TMK-85', 'RMK'),
(105, 'Namakkal', 'Senthamangalam', 326, 1159, 28, 'RMK-213,PMK-258,SMK-199,TMK-410', 'TMK', 130, 316, 'RMK-34,PMK-40,SMK-47,TMK-9', 'SMK', 'RMK-66,PMK-70,SMK-85,TMK-95', 'TMK'),
(91, 'Madurai', 'Sholavandan', 438, 1252, 34, 'RMK-198,PMK-367,SMK-279,TMK-323', 'PMK', 185, 338, 'RMK-48,PMK-40,SMK-47,TMK-50', 'TMK', 'RMK-75,PMK-71,SMK-92,TMK-100', 'TMK'),
(212, 'Vellore', 'Sholingur', 270, 1711, 15, 'RMK-498,PMK-468,SMK-258,TMK-389', 'RMK', 153, 262, 'RMK-42,PMK-42,SMK-22,TMK-47', 'TMK', 'RMK-60,PMK-58,SMK-81,TMK-63', 'SMK'),
(64, 'Kancheepuram', 'Shozhinganallur', 442, 1555, 28, 'RMK-399,PMK-494,SMK-326,TMK-286', 'PMK', 123, 341, 'RMK-34,PMK-48,SMK-16,TMK-25', 'PMK', 'RMK-75,PMK-94,SMK-77,TMK-95', 'TMK'),
(25, 'Coimbatore', 'Singanallur', 465, 1075, 43, 'RMK-409,PMK-192,SMK-126,TMK-170', 'RMK', 104, 302, 'RMK-33,PMK-34,SMK-18,TMK-19', 'PMK', 'RMK-98,PMK-53,SMK-70,TMK-81', 'RMK'),
(99, 'Nagapattinam', 'Sirkazhi', 228, 1407, 16, 'RMK-499,PMK-284,SMK-273,TMK-197', 'RMK', 159, 292, 'RMK-17,PMK-49,SMK-49,TMK-44', 'PMK', 'RMK-97,PMK-53,SMK-54,TMK-88', 'RMK'),
(132, 'Sivagangai', 'Sivaganga', 336, 1428, 23, 'RMK-478,PMK-103,SMK-498,TMK-241', 'SMK', 115, 342, 'RMK-24,PMK-39,SMK-18,TMK-34', 'PMK', 'RMK-83,PMK-93,SMK-87,TMK-79', 'PMK'),
(230, 'Virudhunagar', 'Sivakasi', 394, 1272, 30, 'RMK-360,PMK-170,SMK-295,TMK-248', 'RMK', 147, 256, 'RMK-48,PMK-49,SMK-19,TMK-31', 'PMK', 'RMK-66,PMK-88,SMK-51,TMK-51', 'PMK'),
(65, 'Kancheepuram', 'Sriperumbudur', 339, 1230, 27, 'RMK-370,PMK-363,SMK-100,TMK-275', 'RMK', 97, 315, 'RMK-29,PMK-5,SMK-14,TMK-49', 'TMK', 'RMK-94,PMK-92,SMK-60,TMK-69', 'RMK'),
(180, 'Tiruchirappalli', 'Srirangam', 312, 1442, 21, 'RMK-430,PMK-117,SMK-454,TMK-268', 'SMK', 153, 301, 'RMK-45,PMK-49,SMK-46,TMK-13', 'PMK', 'RMK-68,PMK-67,SMK-66,TMK-100', 'TMK'),
(172, 'Thoothukudi', 'Srivaikuntam', 378, 1236, 30, 'RMK-391,PMK-119,SMK-403,TMK-231', 'SMK', 146, 339, 'RMK-48,PMK-21,SMK-44,TMK-33', 'RMK', 'RMK-83,PMK-72,SMK-95,TMK-89', 'SMK'),
(231, 'Virudhunagar', 'Srivilliputhur', 364, 1596, 22, 'RMK-446,PMK-331,SMK-195,TMK-425', 'RMK', 87, 306, 'RMK-10,PMK-39,SMK-23,TMK-15', 'PMK', 'RMK-88,PMK-79,SMK-62,TMK-77', 'RMK'),
(26, 'Coimbatore', 'Sulur', 327, 1008, 32, 'RMK-183,PMK-208,SMK-308,TMK-259', 'SMK', 94, 262, 'RMK-14,PMK-32,SMK-40,TMK-8', 'SMK', 'RMK-53,PMK-55,SMK-66,TMK-88', 'TMK'),
(66, 'Kancheepuram', 'Tambaram', 358, 1172, 30, 'RMK-129,PMK-353,SMK-258,TMK-322', 'PMK', 79, 349, 'RMK-17,PMK-32,SMK-24,TMK-6', 'PMK', 'RMK-94,PMK-63,SMK-96,TMK-96', 'SMK'),
(192, 'Tirunelveli', 'Tenkasi', 490, 1275, 38, 'RMK-226,PMK-253,SMK-460,TMK-195', 'SMK', 138, 310, 'RMK-49,PMK-10,SMK-48,TMK-31', 'RMK', 'RMK-98,PMK-99,SMK-52,TMK-61', 'PMK'),
(82, 'Krishnagiri', 'Thalli', 225, 883, 25, 'RMK-293,PMK-162,SMK-163,TMK-103', 'RMK', 92, 272, 'RMK-21,PMK-47,SMK-6,TMK-18', 'PMK', 'RMK-82,PMK-53,SMK-65,TMK-72', 'RMK'),
(13, 'Chennai', 'Thiru-Vi-Ka-Nagar', 326, 1092, 29, 'RMK-136,PMK-164,SMK-336,TMK-262', 'SMK', 122, 347, 'RMK-49,PMK-34,SMK-32,TMK-7', 'RMK', 'RMK-96,PMK-85,SMK-74,TMK-92', 'RMK'),
(174, 'Thoothukudi', 'Thiruchendur', 285, 1315, 21, 'RMK-334,PMK-478,SMK-123,TMK-348', 'PMK', 126, 267, 'RMK-23,PMK-14,SMK-39,TMK-50', 'TMK', 'RMK-55,PMK-62,SMK-87,TMK-63', 'SMK'),
(106, 'Namakkal', 'Thiruchengodu', 365, 993, 36, 'RMK-169,PMK-442,SMK-156,TMK-170', 'PMK', 166, 313, 'RMK-32,PMK-50,SMK-46,TMK-38', 'PMK', 'RMK-89,PMK-54,SMK-83,TMK-87', 'RMK'),
(92, 'Madurai', 'Thirumangalam', 417, 1007, 41, 'RMK-139,PMK-252,SMK-137,TMK-372', 'TMK', 71, 285, 'RMK-21,PMK-31,SMK-11,TMK-8', 'PMK', 'RMK-66,PMK-71,SMK-90,TMK-58', 'SMK'),
(113, 'Pudukkottai', 'Thirumayam', 468, 1497, 31, 'RMK-317,PMK-471,SMK-373,TMK-219', 'PMK', 167, 328, 'RMK-37,PMK-43,SMK-40,TMK-47', 'TMK', 'RMK-73,PMK-98,SMK-95,TMK-62', 'PMK'),
(93, 'Madurai', 'Thiruparankundram', 327, 1081, 30, 'RMK-382,PMK-179,SMK-289,TMK-131', 'RMK', 120, 233, 'RMK-39,PMK-34,SMK-34,TMK-13', 'RMK', 'RMK-54,PMK-64,SMK-54,TMK-61', 'PMK'),
(213, 'Vellore', 'Thirupattur', 344, 1525, 22, 'RMK-208,PMK-424,SMK-380,TMK-395', 'PMK', 118, 350, 'RMK-22,PMK-25,SMK-30,TMK-41', 'TMK', 'RMK-90,PMK-92,SMK-84,TMK-84', 'PMK'),
(67, 'Kancheepuram', 'Thiruporur', 328, 1130, 29, 'RMK-423,PMK-188,SMK-254,TMK-118', 'RMK', 79, 326, 'RMK-23,PMK-17,SMK-15,TMK-24', 'TMK', 'RMK-81,PMK-69,SMK-92,TMK-84', 'SMK'),
(168, 'Thiruvarur', 'Thiruthuraipoondi', 326, 1308, 24, 'RMK-212,PMK-364,SMK-407,TMK-271', 'SMK', 114, 263, 'RMK-38,PMK-23,SMK-44,TMK-9', 'SMK', 'RMK-58,PMK-87,SMK-65,TMK-53', 'PMK'),
(118, 'Ramanathapuram', 'Thiruvadanai', 399, 1399, 28, 'RMK-210,PMK-146,SMK-392,TMK-462', 'TMK', 62, 332, 'RMK-17,PMK-16,SMK-17,TMK-12', 'RMK', 'RMK-72,PMK-92,SMK-91,TMK-77', 'PMK'),
(139, 'Thanjavur', 'Thiruvaiyaru', 277, 723, 38, 'RMK-131,PMK-136,SMK-219,TMK-106', 'SMK', 116, 332, 'RMK-26,PMK-25,SMK-16,TMK-49', 'TMK', 'RMK-64,PMK-93,SMK-81,TMK-94', 'TMK'),
(155, 'Thiruvallur', 'Thiruvallur', 317, 1329, 23, 'RMK-180,PMK-158,SMK-451,TMK-430', 'SMK', 73, 328, 'RMK-11,PMK-10,SMK-15,TMK-37', 'TMK', 'RMK-96,PMK-58,SMK-100,TMK-74', 'SMK'),
(164, 'Thiruvannamalai', 'Thiruvannamalai', 439, 1507, 29, 'RMK-309,PMK-481,SMK-223,TMK-352', 'PMK', 136, 355, 'RMK-45,PMK-9,SMK-50,TMK-32', 'SMK', 'RMK-99,PMK-69,SMK-94,TMK-93', 'RMK'),
(169, 'Thiruvarur', 'Thiruvarur', 334, 1494, 22, 'RMK-357,PMK-467,SMK-268,TMK-325', 'PMK', 99, 295, 'RMK-24,PMK-45,SMK-22,TMK-8', 'PMK', 'RMK-63,PMK-95,SMK-65,TMK-72', 'PMK'),
(181, 'Tiruchirappalli', 'Thiruverumbur', 261, 1130, 23, 'RMK-326,PMK-117,SMK-160,TMK-343', 'TMK', 98, 310, 'RMK-24,PMK-26,SMK-43,TMK-5', 'SMK', 'RMK-96,PMK-60,SMK-70,TMK-84', 'RMK'),
(140, 'Thanjavur', 'Thiruvidaimarudur', 339, 1164, 29, 'RMK-250,PMK-149,SMK-466,TMK-192', 'SMK', 153, 271, 'RMK-43,PMK-38,SMK-33,TMK-39', 'RMK', 'RMK-53,PMK-74,SMK-68,TMK-76', 'TMK'),
(156, 'Thiruvallur', 'Thiruvottiyur', 461, 1407, 32, 'RMK-497,PMK-459,SMK-211,TMK-201', 'RMK', 120, 311, 'RMK-29,PMK-9,SMK-38,TMK-44', 'TMK', 'RMK-68,PMK-86,SMK-69,TMK-88', 'TMK'),
(14, 'Chennai', 'Thiyagarayanagar', 372, 1071, 34, 'RMK-359,PMK-225,SMK-356,TMK-110', 'RMK', 97, 300, 'RMK-14,PMK-44,SMK-13,TMK-26', 'PMK', 'RMK-57,PMK-95,SMK-67,TMK-81', 'PMK'),
(27, 'Coimbatore', 'Thondamuthur', 313, 1393, 22, 'RMK-178,PMK-303,SMK-492,TMK-340', 'SMK', 91, 345, 'RMK-20,PMK-27,SMK-34,TMK-10', 'SMK', 'RMK-97,PMK-74,SMK-77,TMK-97', 'RMK'),
(173, 'Thoothukudi', 'Thoothukkudi', 348, 1708, 20, 'RMK-469,PMK-349,SMK-236,TMK-496', 'TMK', 93, 285, 'RMK-13,PMK-12,SMK-22,TMK-46', 'TMK', 'RMK-67,PMK-77,SMK-78,TMK-63', 'SMK'),
(15, 'Chennai', 'Thousand Lights', 445, 986, 45, 'RMK-462,PMK-136,SMK-157,TMK-156', 'RMK', 95, 288, 'RMK-27,PMK-10,SMK-14,TMK-44', 'TMK', 'RMK-66,PMK-55,SMK-100,TMK-67', 'SMK'),
(182, 'Tiruchirappalli', 'Thuraiyur', 422, 1745, 24, 'RMK-353,PMK-312,SMK-493,TMK-404', 'SMK', 62, 281, 'RMK-7,PMK-6,SMK-23,TMK-26', 'TMK', 'RMK-59,PMK-92,SMK-65,TMK-65', 'PMK'),
(221, 'Villupuram', 'Tindivanam', 366, 1446, 25, 'RMK-477,PMK-433,SMK-100,TMK-337', 'RMK', 125, 340, 'RMK-42,PMK-49,SMK-29,TMK-5', 'PMK', 'RMK-52,PMK-90,SMK-98,TMK-100', 'TMK'),
(183, 'Tiruchirappalli', 'Tiruchirappalli(East)', 378, 1530, 24, 'RMK-474,PMK-345,SMK-300,TMK-226', 'RMK', 85, 303, 'RMK-24,PMK-6,SMK-50,TMK-5', 'SMK', 'RMK-83,PMK-54,SMK-82,TMK-84', 'TMK'),
(184, 'Tiruchirappalli', 'Tiruchirappalli(West)', 286, 1748, 16, 'RMK-492,PMK-352,SMK-450,TMK-354', 'RMK', 92, 291, 'RMK-11,PMK-24,SMK-49,TMK-8', 'SMK', 'RMK-64,PMK-68,SMK-74,TMK-85', 'TMK'),
(232, 'Virudhunagar', 'Tiruchuli', 400, 1257, 31, 'RMK-278,PMK-214,SMK-317,TMK-393', 'TMK', 139, 270, 'RMK-50,PMK-39,SMK-16,TMK-34', 'RMK', 'RMK-99,PMK-59,SMK-52,TMK-60', 'RMK'),
(222, 'Villupuram', 'Tirukkoyilur', 272, 1539, 17, 'RMK-209,PMK-442,SMK-474,TMK-370', 'SMK', 183, 303, 'RMK-48,PMK-45,SMK-43,TMK-47', 'RMK', 'RMK-74,PMK-87,SMK-58,TMK-84', 'PMK'),
(193, 'Tirunelveli', 'Tirunelveli', 306, 1105, 27, 'RMK-102,PMK-324,SMK-193,TMK-472', 'TMK', 87, 255, 'RMK-17,PMK-25,SMK-22,TMK-23', 'PMK', 'RMK-66,PMK-66,SMK-61,TMK-62', 'RMK'),
(133, 'Sivagangai', 'Tiruppattur', 363, 1282, 28, 'RMK-273,PMK-140,SMK-477,TMK-332', 'SMK', 92, 277, 'RMK-18,PMK-36,SMK-12,TMK-26', 'PMK', 'RMK-62,PMK-93,SMK-51,TMK-71', 'PMK'),
(200, 'Tiruppur', 'Tiruppur(North)', 467, 1601, 29, 'RMK-271,PMK-418,SMK-465,TMK-266', 'SMK', 102, 346, 'RMK-24,PMK-44,SMK-25,TMK-9', 'PMK', 'RMK-80,PMK-94,SMK-94,TMK-78', 'PMK'),
(201, 'Tiruppur', 'Tiruppur(South)', 373, 1606, 23, 'RMK-162,PMK-470,SMK-500,TMK-277', 'SMK', 109, 291, 'RMK-20,PMK-36,SMK-24,TMK-29', 'PMK', 'RMK-98,PMK-70,SMK-55,TMK-68', 'RMK'),
(157, 'Thiruvallur', 'Tiruttani', 407, 1184, 34, 'RMK-194,PMK-274,SMK-456,TMK-118', 'SMK', 152, 326, 'RMK-47,PMK-50,SMK-7,TMK-48', 'PMK', 'RMK-60,PMK-99,SMK-70,TMK-97', 'PMK'),
(36, 'Cuddalore', 'Tittakudi', 328, 1477, 22, 'RMK-496,PMK-341,SMK-223,TMK-228', 'RMK', 77, 304, 'RMK-18,PMK-11,SMK-20,TMK-28', 'TMK', 'RMK-83,PMK-72,SMK-68,TMK-81', 'RMK'),
(143, 'The Nilgiris', 'Udhagamandalam', 290, 1319, 21, 'RMK-270,PMK-412,SMK-175,TMK-410', 'PMK', 95, 290, 'RMK-20,PMK-37,SMK-14,TMK-24', 'PMK', 'RMK-84,PMK-70,SMK-83,TMK-53', 'RMK'),
(202, 'Tiruppur', 'Udumalaipettail', 277, 1708, 16, 'RMK-124,PMK-453,SMK-465,TMK-497', 'TMK', 70, 308, 'RMK-7,PMK-21,SMK-32,TMK-10', 'SMK', 'RMK-84,PMK-68,SMK-63,TMK-93', 'TMK'),
(223, 'Villupuram', 'Ulundurpettai', 313, 1057, 29, 'RMK-184,PMK-383,SMK-222,TMK-256', 'PMK', 144, 291, 'RMK-9,PMK-38,SMK-49,TMK-48', 'SMK', 'RMK-80,PMK-63,SMK-88,TMK-60', 'SMK'),
(94, 'Madurai', 'Usilampatti', 398, 1545, 25, 'RMK-445,PMK-391,SMK-279,TMK-380', 'RMK', 77, 325, 'RMK-5,PMK-28,SMK-32,TMK-12', 'SMK', 'RMK-75,PMK-72,SMK-84,TMK-94', 'TMK'),
(83, 'Krishnagiri', 'Uthangarai', 349, 1413, 24, 'RMK-412,PMK-282,SMK-485,TMK-212', 'SMK', 79, 336, 'RMK-15,PMK-11,SMK-16,TMK-37', 'TMK', 'RMK-63,PMK-87,SMK-88,TMK-98', 'TMK'),
(68, 'Kancheepuram', 'Uthiramerur', 405, 1584, 25, 'RMK-483,PMK-128,SMK-458,TMK-466', 'RMK', 94, 310, 'RMK-38,PMK-21,SMK-15,TMK-20', 'RMK', 'RMK-69,PMK-86,SMK-79,TMK-76', 'PMK'),
(28, 'Coimbatore', 'Valparai', 301, 1074, 28, 'RMK-111,PMK-238,SMK-433,TMK-171', 'SMK', 74, 286, 'RMK-7,PMK-18,SMK-31,TMK-18', 'SMK', 'RMK-70,PMK-95,SMK-70,TMK-51', 'PMK'),
(165, 'Thiruvannamalai', 'Vandavasi', 384, 1159, 33, 'RMK-409,PMK-327,SMK-231,TMK-124', 'RMK', 121, 300, 'RMK-40,PMK-5,SMK-30,TMK-46', 'TMK', 'RMK-62,PMK-85,SMK-88,TMK-65', 'SMK'),
(214, 'Vellore', 'Vaniyambadi', 317, 1398, 22, 'RMK-233,PMK-318,SMK-230,TMK-462', 'TMK', 104, 363, 'RMK-6,PMK-26,SMK-42,TMK-30', 'SMK', 'RMK-99,PMK-68,SMK-99,TMK-97', 'RMK'),
(224, 'Villupuram', 'Vanur', 363, 1069, 33, 'RMK-225,PMK-235,SMK-366,TMK-220', 'SMK', 118, 258, 'RMK-23,PMK-35,SMK-35,TMK-25', 'PMK', 'RMK-64,PMK-55,SMK-78,TMK-61', 'SMK'),
(194, 'Tirunelveli', 'Vasudevanallur', 410, 1118, 36, 'RMK-213,PMK-427,SMK-224,TMK-150', 'PMK', 129, 341, 'RMK-26,PMK-39,SMK-45,TMK-19', 'SMK', 'RMK-97,PMK-55,SMK-96,TMK-93', 'RMK'),
(100, 'Nagapattinam', 'Vedaranyam', 344, 1517, 22, 'RMK-475,PMK-388,SMK-266,TMK-200', 'RMK', 98, 332, 'RMK-23,PMK-21,SMK-18,TMK-36', 'TMK', 'RMK-92,PMK-79,SMK-88,TMK-73', 'RMK'),
(49, 'Dindigul', 'Vedasandur', 351, 1112, 31, 'RMK-273,PMK-206,SMK-450,TMK-143', 'SMK', 87, 303, 'RMK-16,PMK-31,SMK-32,TMK-8', 'SMK', 'RMK-96,PMK-60,SMK-84,TMK-63', 'RMK'),
(128, 'Salem', 'Veerapandi', 418, 1103, 37, 'RMK-137,PMK-109,SMK-276,TMK-400', 'TMK', 127, 254, 'RMK-38,PMK-39,SMK-38,TMK-12', 'PMK', 'RMK-55,PMK-78,SMK-58,TMK-63', 'PMK'),
(16, 'Chennai', 'Velachery', 348, 752, 46, 'RMK-126,PMK-136,SMK-132,TMK-283', 'TMK', 131, 286, 'RMK-32,PMK-37,SMK-19,TMK-43', 'TMK', 'RMK-52,PMK-79,SMK-70,TMK-85', 'TMK'),
(215, 'Vellore', 'Vellore', 333, 1126, 29, 'RMK-130,PMK-210,SMK-373,TMK-343', 'SMK', 86, 329, 'RMK-18,PMK-40,SMK-23,TMK-5', 'PMK', 'RMK-89,PMK-95,SMK-71,TMK-74', 'PMK'),
(84, 'Krishnagiri', 'Veppanahalli', 365, 1658, 22, 'RMK-469,PMK-234,SMK-382,TMK-448', 'RMK', 169, 337, 'RMK-43,PMK-41,SMK-42,TMK-43', 'RMK', 'RMK-83,PMK-88,SMK-86,TMK-80', 'PMK'),
(225, 'Villupuram', 'Vikravandi', 335, 1748, 19, 'RMK-409,PMK-489,SMK-476,TMK-241', 'PMK', 145, 303, 'RMK-39,PMK-30,SMK-40,TMK-36', 'SMK', 'RMK-52,PMK-85,SMK-91,TMK-75', 'SMK'),
(175, 'Thoothukudi', 'Vilathikulam', 395, 1847, 21, 'RMK-489,PMK-355,SMK-497,TMK-455', 'SMK', 86, 304, 'RMK-10,PMK-16,SMK-45,TMK-15', 'SMK', 'RMK-54,PMK-79,SMK-72,TMK-99', 'TMK'),
(74, 'Kanniyakumari', 'Vilavancode', 323, 1569, 20, 'RMK-264,PMK-432,SMK-338,TMK-492', 'TMK', 157, 297, 'RMK-16,PMK-50,SMK-50,TMK-41', 'PMK', 'RMK-51,PMK-51,SMK-99,TMK-96', 'SMK'),
(17, 'Chennai', 'Villivakkam', 433, 1457, 29, 'RMK-157,PMK-490,SMK-263,TMK-359', 'PMK', 125, 297, 'RMK-15,PMK-49,SMK-14,TMK-47', 'PMK', 'RMK-66,PMK-100,SMK-71,TMK-60', 'PMK'),
(226, 'Villupuram', 'Villupuram', 375, 1334, 28, 'RMK-226,PMK-312,SMK-253,TMK-382', 'TMK', 114, 314, 'RMK-9,PMK-31,SMK-35,TMK-39', 'TMK', 'RMK-91,PMK-81,SMK-78,TMK-64', 'RMK'),
(114, 'Pudukkottai', 'Viralimalai', 343, 1161, 29, 'RMK-137,PMK-269,SMK-254,TMK-354', 'TMK', 92, 326, 'RMK-17,PMK-50,SMK-6,TMK-19', 'PMK', 'RMK-94,PMK-90,SMK-57,TMK-85', 'RMK'),
(233, 'Virudhunagar', 'Virudhunagar', 294, 1335, 22, 'RMK-363,PMK-290,SMK-149,TMK-384', 'TMK', 110, 290, 'RMK-33,PMK-14,SMK-33,TMK-30', 'RMK', 'RMK-52,PMK-88,SMK-56,TMK-94', 'TMK'),
(18, 'Chennai', 'Virugampakkam', 309, 1440, 21, 'RMK-477,PMK-461,SMK-130,TMK-267', 'RMK', 147, 312, 'RMK-25,PMK-24,SMK-49,TMK-49', 'SMK', 'RMK-73,PMK-69,SMK-81,TMK-89', 'TMK'),
(37, 'Cuddalore', 'Vriddhachalam', 472, 1314, 35, 'RMK-177,PMK-315,SMK-295,TMK-459', 'TMK', 152, 343, 'RMK-43,PMK-41,SMK-37,TMK-31', 'RMK', 'RMK-84,PMK-96,SMK-90,TMK-73', 'PMK'),
(129, 'Salem', 'Yercaud', 469, 1175, 39, 'RMK-110,PMK-468,SMK-141,TMK-268', 'PMK', 109, 282, 'RMK-41,PMK-5,SMK-38,TMK-25', 'RMK', 'RMK-89,PMK-73,SMK-54,TMK-66', 'RMK');

-- --------------------------------------------------------

--
-- Table structure for table `vt_officer1`
--

CREATE TABLE `vt_officer1` (
  `id` int(11) NOT NULL,
  `state` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_officer1`
--

INSERT INTO `vt_officer1` (`id`, `state`, `name`, `contact`, `email`, `uname`, `pass`) VALUES
(1, 'Tamilnadu', 'Santhosh', 9964327811, 'santhosh@gmail.com', 'R001', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `vt_poll`
--

CREATE TABLE `vt_poll` (
  `id` int(11) NOT NULL,
  `officer` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `uname` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_poll`
--

INSERT INTO `vt_poll` (`id`, `officer`, `name`, `contact`, `email`, `uname`, `pass`) VALUES
(1, 'B001', 'Raj', 9361535129, 'raj@gmail.com', 'P001', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `vt_temp`
--

CREATE TABLE `vt_temp` (
  `id` int(11) NOT NULL,
  `caption` varchar(30) NOT NULL,
  `vcount` int(11) NOT NULL,
  `seats` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_temp`
--

INSERT INTO `vt_temp` (`id`, `caption`, `vcount`, `seats`) VALUES
(1, 'RMK', 68928, 64),
(2, 'PMK', 69594, 55),
(3, 'SMK', 69002, 55),
(4, 'TMK', 69945, 59);

-- --------------------------------------------------------

--
-- Table structure for table `vt_vote`
--

CREATE TABLE `vt_vote` (
  `id` int(11) NOT NULL,
  `voterid` varchar(30) NOT NULL,
  `cid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_vote`
--

INSERT INTO `vt_vote` (`id`, `voterid`, `cid`) VALUES
(1, 'V1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `vt_voter`
--

CREATE TABLE `vt_voter` (
  `id` int(11) NOT NULL,
  `division` varchar(40) NOT NULL,
  `voterid` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(15) NOT NULL,
  `address` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  `city` varchar(30) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `aadhar` varchar(30) NOT NULL,
  `finger` varchar(50) NOT NULL,
  `finger_st` int(11) NOT NULL,
  `rdate` varchar(15) NOT NULL,
  `secret` varchar(20) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `sms_st` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `vote_st` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `finger_img` varchar(30) NOT NULL,
  `src_img1` varchar(30) NOT NULL,
  `src_img2` varchar(30) NOT NULL,
  `finger_img2` varchar(30) NOT NULL,
  `dest_img1` varchar(30) NOT NULL,
  `dest_img2` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_voter`
--

INSERT INTO `vt_voter` (`id`, `division`, `voterid`, `name`, `gender`, `dob`, `address`, `area`, `city`, `contact`, `email`, `aadhar`, `finger`, `finger_st`, `rdate`, `secret`, `pass`, `sms_st`, `status`, `vote_st`, `cid`, `finger_img`, `src_img1`, `src_img2`, `finger_img2`, `dest_img1`, `dest_img2`) VALUES
(1, 'Srirangam', 'V1221001', 'Raj', 'Male', '11-08-1997', '33,dd', 'Ramji Nagar', 'Tiruchirappalli', 9976570006, 'raj@gmail.com', '432156784321', '', 1, '11-03-2020', '18668', 'raj362', 0, 0, 0, 3, '', '', '', '', '', ''),
(2, 'Srirangam', 'V1221002', 'Priya', 'Female', '04-03-1998', '45,SS Nagar', 'Ramji Nagar', 'Tiruchirappalli', 9976570006, 'priya@myinfo.in', '567801234321', '', 0, '11-03-2020', '', 'pri538', 0, 0, 0, 3, '', '', '', '', '', ''),
(3, 'Srirangam', 'V1221003', 'Nisha', 'Female', '25-11-1991', '345/7, 4th cross', 'Ramji Nagar', 'Tiruchirappalli', 8844623416, 'nisha@gmail.com', '346620984513', '', 0, '19-12-2021', '', 'nis609', 0, 0, 0, 0, '', '', '', '', '', ''),
(4, 'Srirangam', 'V1221004', 'Krishna', 'Male', '07-12-1991', '501,11th cross', 'Kumar Nagar', 'Tiruchirappalli', 8844623562, 'krishna@gmail.com', '432144336888', '', 0, '20-12-2021', '', 'kri729', 0, 0, 0, 0, '', '', '', '', '', ''),
(5, 'Srirangam', 'V1221005', 'Sathish', 'Male', '08-12-1992', '345/7, 4th cross', 'Kumaran Nagar', 'Tiruchirappalli', 8844623562, 'sathish@gmail.com', '432130041266', '', 1, '20-12-2021', '', 'sat802', 0, 0, 0, 0, '', '', '', '', '', ''),
(6, 'Jayankondam', 'V1221006', 'Rahul', 'Male', '24-11-1990', '33,ff', 'dd road', 'Ariyalur', 9034588192, 'rahul@gmail.com', '775544771122', '', 0, '25-12-2021', '', 'rah378', 0, 0, 0, 0, 'F6m1.jpg', 'AIM6_m1.jpg', 'BIM6_m1.jpg', 'FF6_m3.jpg', 'CIM6_m3.jpg', 'DIM6_m3.jpg'),
(7, 'Srirangam', 'V1221007', 'Suba', 'Female', '12-10-1995', '33,gg', 'ss colony', 'Tiruchirappalli', 8801326571, 'suba@gmail.com', '667788994455', '', 1, '25-12-2021', '', 'sub429', 0, 0, 0, 0, 'F7m3.jpg', 'AIM7_m3.jpg', 'BIM7_m3.jpg', 'FF7_m3.jpg', 'CIM7_m3.jpg', 'DIM7_m3.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `vt_voter2`
--

CREATE TABLE `vt_voter2` (
  `id` int(11) NOT NULL,
  `voterid` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(15) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `aadhar` varchar(30) NOT NULL,
  `finger_img` varchar(50) NOT NULL,
  `finger_img2` varchar(50) NOT NULL,
  `src_img1` varchar(50) NOT NULL,
  `src_img2` varchar(50) NOT NULL,
  `dest_img1` varchar(50) NOT NULL,
  `dest_img2` varchar(50) NOT NULL,
  `finger` varchar(50) NOT NULL,
  `finger_st` int(11) NOT NULL,
  `rdate` varchar(15) NOT NULL,
  `secret` varchar(20) NOT NULL,
  `sms_st` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_voter2`
--


-- --------------------------------------------------------

--
-- Table structure for table `vt_vote_reg`
--

CREATE TABLE `vt_vote_reg` (
  `id` int(11) NOT NULL,
  `vid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `caption` varchar(30) NOT NULL,
  `dtime` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vt_vote_reg`
--

