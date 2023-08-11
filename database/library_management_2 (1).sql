-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 11, 2023 at 11:50 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management_2`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `authorname` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `authorname`, `email`, `phone`, `address`) VALUES
(1, 'fdjfldfj', NULL, NULL, NULL),
(2, 'fdifdufid', NULL, NULL, NULL),
(3, 'Minh', NULL, NULL, NULL),
(4, 'Minh2', NULL, NULL, NULL),
(5, 'Minh3', NULL, NULL, NULL),
(6, 'dkfdf', NULL, NULL, NULL),
(7, 'Minh1', NULL, NULL, NULL),
(8, 'jdfd', NULL, NULL, NULL),
(9, 'cdcdlckc', NULL, NULL, NULL),
(10, 'jfsjfdfd', NULL, NULL, NULL),
(11, 'fhfdfodf', NULL, NULL, NULL),
(12, 'dvfdfd', NULL, NULL, NULL),
(13, 'sfhsdg', NULL, NULL, NULL),
(14, 'dsgfsudfgd', NULL, NULL, NULL),
(15, 'fsadyfidf', NULL, NULL, NULL),
(16, 'fdhfisd', NULL, NULL, NULL),
(17, 'gfdf', NULL, NULL, NULL),
(18, 'cvdcvd', NULL, NULL, NULL),
(19, 'fhdfhdf', NULL, NULL, NULL),
(20, 'dfdf\r\n', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bookauthor`
--

CREATE TABLE `bookauthor` (
  `id` int(11) NOT NULL,
  `booktitle_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookauthor`
--

INSERT INTO `bookauthor` (`id`, `booktitle_id`, `author_id`) VALUES
(13, 14, 12),
(14, 14, 13),
(15, 14, 14),
(16, 15, 15),
(17, 15, 16),
(21, 18, 20);

-- --------------------------------------------------------

--
-- Table structure for table `bookdamagerule`
--

CREATE TABLE `bookdamagerule` (
  `id` int(11) NOT NULL,
  `bookdamagemin` int(11) NOT NULL,
  `bookdamagemax` int(11) NOT NULL,
  `action` varchar(255) NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookdamagerule`
--

INSERT INTO `bookdamagerule` (`id`, `bookdamagemin`, `bookdamagemax`, `action`, `fine`) VALUES
(1, 0, 5, 'Giữ sách', 0),
(2, 5, 15, 'Giữ sách', 50000),
(3, 15, 30, 'Giữ sách', 80000),
(4, 30, 50, 'Giữ sách', 100000),
(5, 50, 80, 'Giữ sách', 120000),
(6, 80, 100, 'Bỏ sách', 150000);

-- --------------------------------------------------------

--
-- Table structure for table `bookdetail`
--

CREATE TABLE `bookdetail` (
  `id` int(11) NOT NULL,
  `bookpart_id` int(11) NOT NULL,
  `bookstatus` int(11) NOT NULL DEFAULT 100
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookdetail`
--

INSERT INTO `bookdetail` (`id`, `bookpart_id`, `bookstatus`) VALUES
(20, 12, 95),
(21, 12, 100),
(22, 12, 100),
(23, 12, 100),
(24, 13, 100),
(25, 13, 90),
(26, 13, 100),
(27, 13, 100),
(28, 14, 100),
(29, 14, 100),
(30, 14, 100),
(31, 14, 100),
(32, 15, 100),
(33, 15, 100),
(34, 15, 100),
(35, 15, 100),
(36, 16, 100),
(37, 16, 100),
(38, 16, 95),
(39, 17, 100),
(40, 17, 100),
(41, 17, 100),
(42, 18, 100),
(43, 18, 100),
(44, 18, 100),
(52, 23, 100),
(53, 23, 100),
(54, 23, 100),
(55, 23, 100),
(56, 24, 100),
(57, 24, 100),
(58, 24, 100),
(59, 24, 100),
(60, 25, 100),
(61, 25, 100),
(62, 25, 100),
(63, 25, 100),
(64, 25, 100);

-- --------------------------------------------------------

--
-- Table structure for table `bookgenre`
--

CREATE TABLE `bookgenre` (
  `id` int(11) NOT NULL,
  `booktitle_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookgenre`
--

INSERT INTO `bookgenre` (`id`, `booktitle_id`, `genre_id`) VALUES
(13, 14, 1),
(14, 15, 1),
(15, 15, 2),
(16, 15, 3),
(20, 14, 6);

-- --------------------------------------------------------

--
-- Table structure for table `bookpart`
--

CREATE TABLE `bookpart` (
  `id` int(11) NOT NULL,
  `booktitle_id` int(11) NOT NULL,
  `partnumber` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bookpart`
--

INSERT INTO `bookpart` (`id`, `booktitle_id`, `partnumber`) VALUES
(12, 14, '1'),
(13, 14, '2'),
(14, 14, '3'),
(15, 14, '4'),
(16, 15, '1'),
(17, 15, '2'),
(18, 15, '3'),
(23, 18, '1'),
(24, 18, '2'),
(25, 14, '5');

-- --------------------------------------------------------

--
-- Table structure for table `booktitle`
--

CREATE TABLE `booktitle` (
  `id` int(11) NOT NULL,
  `booktitle` varchar(255) NOT NULL,
  `publishedyear` varchar(255) NOT NULL,
  `publisher_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booktitle`
--

INSERT INTO `booktitle` (`id`, `booktitle`, `publishedyear`, `publisher_id`) VALUES
(14, 'fdsffsa', 'cdfdfdf09', 2),
(15, 'fdksjfhdkjfds', '20323', 1),
(18, 'harry maguire', '2023', 1);

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
  `id` int(11) NOT NULL,
  `bookdetail_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `librarian_id` int(11) NOT NULL,
  `borrowdate` date NOT NULL,
  `duedate` date NOT NULL,
  `returnstatus` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`id`, `bookdetail_id`, `user_id`, `librarian_id`, `borrowdate`, `duedate`, `returnstatus`) VALUES
(1, 22, 2, 1, '2023-07-25', '2023-07-28', 1),
(2, 20, 2, 1, '2023-07-25', '2023-08-02', 1),
(5, 25, 5, 1, '2023-07-25', '2023-07-27', 1),
(6, 28, 6, 1, '2023-08-03', '2023-08-17', 1),
(7, 38, 7, 1, '2023-08-07', '2023-08-16', 1),
(8, 55, 8, 1, '2023-08-11', '2023-08-17', 0);

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id`, `genre`) VALUES
(1, 'Sách giáo khoa'),
(2, 'Sách trinh thám'),
(3, 'Sách khoa học viễn tưởng'),
(4, 'Sách tâm lý học'),
(6, 'Sách tiểu thuyết');

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`id`, `firstname`, `lastname`, `username`, `password`, `email`, `phone`, `address`, `level`) VALUES
(1, 'minh', 'chung', 'minhchung', '123', 'minhchung@gmail.com', '0987654321', 'Ha Noi', 1),
(2, 'nguyen', 'employee', 'employee', 'employee', 'nguyen@gmail.com', '0978563421', 'Ha Noi1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL,
  `publishername` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`id`, `publishername`, `address`, `email`, `phone`) VALUES
(1, 'Nhà xuất bản Giáo Dục', 'Số 1 đường Ngô Quyền phường A quận Thanh Xuân thành phố Hà Nội', 'nxbgiaoduc@gmail.com', '0987654321'),
(2, 'Nhà xuất bản Kim Đồng', 'Số 2 đường A phường B quận C thành phố Hà Nội', 'nxbkimdonmg@gmail.com', '0987654321');

-- --------------------------------------------------------

--
-- Table structure for table `returnbookrule`
--

CREATE TABLE `returnbookrule` (
  `id` int(11) NOT NULL,
  `returnlatefor` varchar(255) NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `returnbookrule`
--

INSERT INTO `returnbookrule` (`id`, `returnlatefor`, `fine`) VALUES
(1, '[1, 3] ngày', 20000),
(2, '[3, 7] ngày', 50000),
(3, '>7 ngày ', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `returnn`
--

CREATE TABLE `returnn` (
  `id` int(11) NOT NULL,
  `bookdetail_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `librarian_id` int(11) NOT NULL,
  `returndate` date NOT NULL,
  `bookstatus` int(11) NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `returnn`
--

INSERT INTO `returnn` (`id`, `bookdetail_id`, `user_id`, `librarian_id`, `returndate`, `bookstatus`, `fine`) VALUES
(2, 25, 5, 1, '2023-07-28', 90, 70000),
(3, 20, 2, 1, '2023-08-05', 95, 100000),
(4, 28, 6, 1, '2023-08-05', 100, 0),
(5, 38, 7, 2, '2023-08-11', 95, 50000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `phone`) VALUES
(1, 'Hung', 'hung@gmail.com', '0987654321'),
(2, 'abc', 'abc1@gmail.com', '0987654321'),
(3, 'abd', 'abd@gmail.com', '0987654321'),
(4, 'fjdhfdfd', 'sfhdsfg@gmail.com', '0987654321'),
(5, 'koko', 'koko@gmail.com', '0987654231'),
(6, 'minh2', 'minh2@gmail.com', '1234567890'),
(7, 'MinhHai', 'minhahi@gmail.com', '0978654321'),
(8, 'Nam', 'nam@gmail.com', '1234567890');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bookauthor`
--
ALTER TABLE `bookauthor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bookauthor_ibfk_1` (`booktitle_id`),
  ADD KEY `bookauthor_ibfk_2` (`author_id`);

--
-- Indexes for table `bookdamagerule`
--
ALTER TABLE `bookdamagerule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bookdetail`
--
ALTER TABLE `bookdetail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bookdetail_ibfk_1` (`bookpart_id`);

--
-- Indexes for table `bookgenre`
--
ALTER TABLE `bookgenre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bookgenre_ibfk_1` (`booktitle_id`),
  ADD KEY `bookgenre_ibfk_2` (`genre_id`);

--
-- Indexes for table `bookpart`
--
ALTER TABLE `bookpart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bookpart_ibfk_1` (`booktitle_id`);

--
-- Indexes for table `booktitle`
--
ALTER TABLE `booktitle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `booktitle_ibfk_1` (`publisher_id`);

--
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
  ADD PRIMARY KEY (`id`),
  ADD KEY `borrow_ibfk_1` (`user_id`),
  ADD KEY `borrow_ibfk_2` (`librarian_id`),
  ADD KEY `borrow_ibfk_3` (`bookdetail_id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `returnbookrule`
--
ALTER TABLE `returnbookrule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `returnn`
--
ALTER TABLE `returnn`
  ADD PRIMARY KEY (`id`),
  ADD KEY `return_ibfk_1` (`librarian_id`),
  ADD KEY `return_ibfk_2` (`user_id`),
  ADD KEY `return_ibfk_3` (`bookdetail_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `bookauthor`
--
ALTER TABLE `bookauthor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `bookdamagerule`
--
ALTER TABLE `bookdamagerule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `bookdetail`
--
ALTER TABLE `bookdetail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `bookgenre`
--
ALTER TABLE `bookgenre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `bookpart`
--
ALTER TABLE `bookpart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `booktitle`
--
ALTER TABLE `booktitle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `borrow`
--
ALTER TABLE `borrow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `returnbookrule`
--
ALTER TABLE `returnbookrule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `returnn`
--
ALTER TABLE `returnn`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookauthor`
--
ALTER TABLE `bookauthor`
  ADD CONSTRAINT `bookauthor_ibfk_1` FOREIGN KEY (`booktitle_id`) REFERENCES `booktitle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bookauthor_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bookdetail`
--
ALTER TABLE `bookdetail`
  ADD CONSTRAINT `bookdetail_ibfk_1` FOREIGN KEY (`bookPart_id`) REFERENCES `bookpart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bookgenre`
--
ALTER TABLE `bookgenre`
  ADD CONSTRAINT `bookgenre_ibfk_1` FOREIGN KEY (`booktitle_id`) REFERENCES `booktitle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bookgenre_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bookpart`
--
ALTER TABLE `bookpart`
  ADD CONSTRAINT `bookpart_ibfk_1` FOREIGN KEY (`bookTitle_id`) REFERENCES `booktitle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `booktitle`
--
ALTER TABLE `booktitle`
  ADD CONSTRAINT `booktitle_ibfk_1` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `borrow`
--
ALTER TABLE `borrow`
  ADD CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `borrow_ibfk_2` FOREIGN KEY (`librarian_id`) REFERENCES `librarian` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `borrow_ibfk_3` FOREIGN KEY (`bookdetail_id`) REFERENCES `bookdetail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `returnn`
--
ALTER TABLE `returnn`
  ADD CONSTRAINT `returnn_ibfk_1` FOREIGN KEY (`librarian_id`) REFERENCES `librarian` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `returnn_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `returnn_ibfk_3` FOREIGN KEY (`bookDetail_id`) REFERENCES `bookdetail` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
