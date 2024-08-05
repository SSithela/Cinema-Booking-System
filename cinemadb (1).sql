-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2023 at 10:59 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinemadb`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `street` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postal_code` int(11) NOT NULL,
  `province` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `date_made` datetime(6) DEFAULT NULL,
  `movie_show_show_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `date_made`, `movie_show_show_id`) VALUES
(1, '2023-10-22 05:29:41.000000', 3),
(2, '2023-10-22 19:08:36.000000', 2),
(3, '2023-10-22 22:19:15.000000', 2),
(4, '2023-10-22 22:24:48.000000', 2);

-- --------------------------------------------------------

--
-- Table structure for table `booking_seats`
--

CREATE TABLE `booking_seats` (
  `booking_booking_id` int(11) NOT NULL,
  `seats_seat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking_seats`
--

INSERT INTO `booking_seats` (`booking_booking_id`, `seats_seat_id`) VALUES
(1, 61),
(1, 62),
(2, 44),
(2, 60),
(3, 39),
(3, 40),
(4, 49),
(4, 50);

-- --------------------------------------------------------

--
-- Table structure for table `cinema`
--

CREATE TABLE `cinema` (
  `cinema_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cinema`
--

INSERT INTO `cinema` (`cinema_id`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `coupon`
--

CREATE TABLE `coupon` (
  `coupon_id` int(11) NOT NULL,
  `balance` double NOT NULL,
  `exp_date` datetime(6) DEFAULT NULL,
  `user_id_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(12, 'Adventure'),
(14, 'Fantasy'),
(16, 'Animation'),
(18, 'Drama'),
(27, 'Horror'),
(28, 'Action'),
(35, 'Comedy'),
(36, 'History'),
(37, 'Western'),
(53, 'Thriller'),
(80, 'Crime'),
(99, 'Documentary'),
(878, 'Science Fiction'),
(9648, 'Mystery'),
(10402, 'Music'),
(10749, 'Romance'),
(10751, 'Family'),
(10752, 'War'),
(10770, 'TV Movie');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_id` int(11) NOT NULL,
  `passowrd` varchar(255) DEFAULT NULL,
  `user_user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movie_id` varchar(255) NOT NULL,
  `backdrop_img` varchar(255) DEFAULT NULL,
  `now_showing` bit(1) NOT NULL,
  `overview` varchar(8000) DEFAULT NULL,
  `poster_img` varchar(255) DEFAULT NULL,
  `ratting` double NOT NULL,
  `release_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movie_id`, `backdrop_img`, `now_showing`, `overview`, `poster_img`, `ratting`, `release_date`, `title`) VALUES
('1008042', '/iIvQnZyzgx9TkbrOgcXx0p7aLiq.jpg', b'0', 'When a group of friends discover how to conjure spirits using an embalmed hand, they become hooked on the new thrill, until one of them goes too far and unleashes terrifying supernatural forces.', '/kdPMUMJzyYAc4roD52qavX0nLIC.jpg', 7.2, '2023-07-26', 'Talk to Me'),
('1024773', '/oP03EF9eYWqvycFGN5TeEo3nN7l.jpg', b'0', 'Desperate to fit in at school, Sam rejects her East Indian culture and family to be like everyone else. However, when a mythological demonic spirit latches onto her former best friend, she must come to terms with her heritage to defeat it.', '/73gIfV8gDwkVgUrFDzt4TfZC9Zc.jpg', 5.3, '2023-09-06', 'It Lives Inside'),
('1047041', '/zZnsfR6BRqtxyLyAhsi2TMukEBx.jpg', b'0', 'The 26th movie entry in the “Detective Conan” franchise.', '/gWrZNGfGz68mBrVPn47cBMXPej3.jpg', 6.5, '2023-04-14', '名探偵コナン 黒鉄の魚影（サブマリン）'),
('1058694', '/gB5guf07SD8wVqxrx4Scp4LFBq4.jpg', b'0', 'In a Mexican border town plagued by neglect, corruption, and violence, a frustrated teacher tries a radical new method to break through his students’ apathy and unlock their curiosity, their potential… and maybe even their genius.', '/zwcmjn3qKhP7kUmpgNT0f61xzU3.jpg', 0, '2023-10-19', 'Radical'),
('1160164', '/x9tsSyltV2N814LtABb41NjVMd7.jpg', b'0', 'The cultural phenomenon continues on the big screen! Immerse yourself in this once-in-a-lifetime concert film experience with a breathtaking, cinematic view of the history-making tour.', '/a5EreVlyB9fXzZ2Rf9ugOLrW5YI.jpg', 8.6, '2023-10-13', 'TAYLOR SWIFT | THE ERAS TOUR'),
('299054', '/rMvPXy8PUjj1o8o1pzgQbdNCsvj.jpg', b'1', 'Armed with every weapon they can get their hands on and the skills to use them, The Expendables are the world’s last line of defense and the team that gets called when all other options are off the table. But new team members with new styles and tactics are going to give “new blood” a whole new meaning.', '/mOX5O6JjCUWtlYp5D8wajuQRVgy.jpg', 6.4, '2023-09-15', 'Expend4bles'),
('346698', '/ctMserH8g2SeOAnCw5gFjdQF8mo.jpg', b'1', 'Barbie and Ken are having the time of their lives in the colorful and seemingly perfect world of Barbie Land. However, when they get a chance to go to the real world, they soon discover the joys and perils of living among humans.', '/iuFNMS8U5cb6xfzi51Dbkovj7vM.jpg', 7.2, '2023-07-19', 'Barbie'),
('466420', '/uvsL5Q5Juf8ivqBnlr4nFVUwVoa.jpg', b'0', 'When oil is discovered in 1920s Oklahoma under Osage Nation land, the Osage people are murdered one by one—until the FBI steps in to unravel the mystery.', '/dB6Krk806zeqd0YNp2ngQ9zXteH.jpg', 7.8, '2023-10-18', 'Killers of the Flower Moon'),
('496450', '/iEFuHjqrE059SmflBva1JzDJutE.jpg', b'0', 'A life of an ordinary Parisian teenager Marinette goes superhuman when she becomes Ladybug. Bestowed with magical powers of creation, Ladybug must unite with her opposite, Cat Noir, to save Paris as a new villain unleashes chaos unto the city.', '/bBON9XO9Ek0DjRwMBnJNCwC96Cd.jpg', 7.8, '2023-07-05', 'Miraculous - le film'),
('502345', '/nCiqQYXJdaw3SqY6XZFx4r1IZTI.jpg', b'0', 'As her world is shrouded in darkness, a young girl must overcome her fears and travel to a mysterious city of light, save her father from a dangerous scientist and prevent the destruction of her planet.', '/1tcLXVaXFG9OObnCN3a5KrymrQG.jpg', 7.4, '2023-10-05', 'Scarygirl'),
('507089', '/whB2PJfxrDWwwksprliJTjYbcZJ.jpg', b'0', 'Recently fired and desperate for work, a troubled young man named Mike agrees to take a position as a night security guard at an abandoned theme restaurant: Freddy Fazbear\'s Pizzeria. But he soon discovers that nothing at Freddy\'s is what it seems.', '/A4j8S6moJS2zNtRR8oWF08gRnL5.jpg', 9.3, '2023-10-25', 'Five Nights at Freddy\'s'),
('508883', '/a0GM57AnJtNi7lMOCamniiyV10W.jpg', b'0', 'While the Second World War rages, the teenage Mahito, haunted by his mother\'s tragic death, is relocated from Tokyo to the serene rural home of his new stepmother Natsuko, a woman who bears a striking resemblance to the boy\'s mother. As he tries to adjust, this strange new world grows even stranger following the appearance of a persistent gray heron, who perplexes and bedevils Mahito, dubbing him the \"long-awaited one.\"', '/ojWgbvGGAHDXlGqNq4SsBuUSJYO.jpg', 7.7, '2023-07-14', '君たちはどう生きるか'),
('565770', '/H6j5smdpRqP9a8UnhWp6zfl0SC.jpg', b'1', 'Recent college grad Jaime Reyes returns home full of aspirations for his future, only to find that home is not quite as he left it. As he searches to find his purpose in the world, fate intervenes when Jaime unexpectedly finds himself in possession of an ancient relic of alien biotechnology: the Scarab.', '/mXLOHHc1Zeuwsl4xYKjKh2280oL.jpg', 7.1, '2023-08-16', 'Blue Beetle'),
('603692', '/7I6VUdPj6tQECNHdviJkUHD2u89.jpg', b'1', 'With the price on his head ever increasing, John Wick uncovers a path to defeating The High Table. But before he can earn his freedom, Wick must face off against a new enemy with powerful alliances across the globe and forces that turn old friends into foes.', '/vZloFAK7NmvMGKE7VkF5UHaz0I.jpg', 7.8, '2023-03-22', 'John Wick: Chapter 4'),
('609681', '/w4pRLYYbhHn3sh9kqRgPZM6GjyS.jpg', b'0', 'Carol Danvers, aka Captain Marvel, has reclaimed her identity from the tyrannical Kree and taken revenge on the Supreme Intelligence. But unintended consequences see Carol shouldering the burden of a destabilized universe. When her duties send her to an anomalous wormhole linked to a Kree revolutionary, her powers become entangled with that of Jersey City super-fan Kamala Khan, aka Ms. Marvel, and Carol’s estranged niece, now S.A.B.E.R. astronaut Captain Monica Rambeau. Together, this unlikely trio must team up and learn to work in concert to save the universe.', '/y4YMYsGSMwu8e985g0Zbumvqxld.jpg', 0, '2023-11-08', 'The Marvels'),
('663712', '/cRdA9xjHBbobw4LJFsQ3j1CgpVq.jpg', b'0', 'After being resurrected by a sinister entity, Art the Clown returns to Miles County where he must hunt down and destroy a teenage girl and her younger brother on Halloween night.  As the body count rises, the siblings fight to stay alive while uncovering the true nature of Art\'s evil intent.', '/8gLhu8UFPZfH2Hv11JhTZkb9CVl.jpg', 6.8, '2022-10-06', 'Terrifier 2'),
('666277', '/rron9HAuS9s7zBF8iCX1tsafxUo.jpg', b'0', 'Two childhood friends are separated after one’s family emigrates from South Korea. Two decades later, they are reunited in New York for one week as they confront notions of destiny, love and the choices that make a life.', '/rzO71VFu7CpJMfF5TQNMj0d1lSV.jpg', 7.9, '2023-06-02', 'Past Lives'),
('675531', '/9qWD2PS8fWeUv3ud3yE9XMoorer.jpg', b'1', 'In a cursed town, the annual harvest becomes a brutal battle for survival. On Halloween 1963, Sawtooth Jack, a terrifying legend, rises from the cornfields, threatening the town’s children. Groups of boys unite to defeat the murderous scarecrow before midnight. Richie, a rebellious outcast, joins the run, motivated by his brother’s previous victory. As the hunt progresses, Richie makes a shocking discovery and faces a pivotal choice to break the relentless cycle.', '/sFBDjWdw8gHSI2dMivP7H52iwvp.jpg', 5.9, '2023-10-11', 'Dark Harvest'),
('678512', '/pA3vdhadJPxF5GA1uo8OPTiNQDT.jpg', b'0', 'The story of Tim Ballard, a former US government agent, who quits his job in order to devote his life to rescuing children from global sex traffickers.', '/qA5kPYZA7FkVvqcEfJRoOy4kpHg.jpg', 8.1, '2023-07-03', 'Sound of Freedom'),
('732684', '/cK9LrH5Ggqf2005AhWrpDT98bHU.jpg', b'1', 'While digging one of the many tunnels for the Moscow metro, Soviet workers unearth ruins of a dungeon. The site is closed, the metro tunnel is diverted, and amidst the bustle no one notices the tunnel workers’ foreman pocketing a little ‘souvenir’ – a book-sized frame made of precious metals featuring an inscription in an unknown language. Decades later, the foreman’s grandson Ilya, who works as a courier, discovers the ancient relic in a pile of old junk. Oblivious to the true value of the family heirloom, he soon learns about it from a mysterious stranger. The relic is the key to the secret location of the priceless ancient library that belonged to Ivan the Terrible. What Ilya doesn’t know is that the search for the lost library has been going on for centuries, and now very powerful people are after him. Ilya and the mysterious stranger decide to try their luck in finding the library.', '/lc0KueWbDDwIsg76JnPohA7jday.jpg', 5.4, '2022-10-27', 'Либерея: Охотники за сокровищами'),
('762430', '/iiXliCeykkzmJ0Eg9RYJ7F2CWSz.jpg', b'1', 'When a mysterious caller puts a bomb under his car seat, Matt Turner begins a high-speed chase across the city to complete a specific series of tasks. With his kids trapped in the back seat and a bomb that will explode if they get out of the car, a normal commute becomes a twisted game of life or death as Matt follows the stranger\'s increasingly dangerous instructions in a race against time to save his family.', '/oUmmY7QWWn7OhKlcPOnirHJpP1F.jpg', 6.9, '2023-08-23', 'Retribution'),
('807172', '/o6kfGs1qTAaFX22YitIvlYMyeqA.jpg', b'1', 'When his daughter, Angela, and her friend Katherine, show signs of demonic possession, it unleashes a chain of events that forces single father Victor Fielding to confront the nadir of evil. Terrified and desperate, he seeks out Chris MacNeil, the only person alive who\'s witnessed anything like it before.', '/lxRLC3WOFM2INoyEa3bFGIUApvn.jpg', 5.4, '2023-10-04', 'The Exorcist: Believer'),
('808396', '/hjyqNFHx5wIO8dqaRi0v2ix1wiR.jpg', b'0', 'Based on true events and the novel of the same name. Vice detective Bob Hightower finds his ex-wife murdered and daughter kidnapped by a cult. Frustrated by the botched official investigations, he quits the force and infiltrates the cult to hunt down the leader with the help of the cult’s only female victim escapee, Case Hardin.', '/5kiLS9nsSJxDdlYUyYGiSUt8Fi8.jpg', 6.3, '2023-06-22', 'God Is a Bullet'),
('814776', '/f9ErVXAyR9EP5WOOp4i5ivBKsKC.jpg', b'0', 'Unpopular best friends PJ and Josie start a high school self-defense club to meet girls and lose their virginity. They soon find themselves in over their heads when the most popular students start beating each other up in the name of self-defense.', '/jeyTQrNEpyE1LZIgVlswYh3sc34.jpg', 7.1, '2023-08-25', 'Bottoms'),
('893723', '/gIchV01EUHd1zNBeql92L63kmHU.jpg', b'0', 'A magical meteor crash-lands in Adventure City, gives the PAW Patrol pups superpowers, and transforms them into The Mighty Pups. When the Patrol\'s archrival Humdinger breaks out of jail and teams up with mad scientist Victoria Vance to steal the powers for themselves, the Mighty Pups must save Adventure City and stop the supervillains before it\'s too late.', '/aTvePCU7exLepwg5hWySjwxojQK.jpg', 7.3, '2023-09-21', 'PAW Patrol: The Mighty Movie'),
('901362', '/45zVtZx6Tzx3RKeDziK25K9geFf.jpg', b'0', 'When Branch’s brother, Floyd, is kidnapped for his musical talents by a pair of nefarious pop-star villains, Branch and Poppy embark on a harrowing and emotional journey to reunite the other brothers and rescue Floyd from a fate even worse than pop-culture obscurity.', '/kaQwboGvF6wZ4hYIvMYMFBgUCp5.jpg', 4.5, '2023-10-12', 'Trolls Band Together'),
('915935', '/kszooR7v1TLFM4pzx6IkKq2jDAN.jpg', b'0', 'When her husband Samuel is mysteriously found dead in the snow below their secluded chalet, Sandra becomes the main suspect when the police begin to question whether he fell or was pushed.', '/kQs6keheMwCxJxrzV83VUwFtHkB.jpg', 7.8, '2023-08-23', 'Anatomie d’une chute'),
('926393', '/cHNqobjzfLj88lpIYqkZpecwQEC.jpg', b'1', 'Robert McCall finds himself at home in Southern Italy but he discovers his friends are under the control of local crime bosses. As events turn deadly, McCall knows what he has to do: become his friends\' protector by taking on the mafia.', '/b0Ej6fnXAP8fK75hlyi2jKqdhHz.jpg', 7.2, '2023-08-30', 'The Equalizer 3'),
('937249', '/jP3FatCTHc460ZGW57q9ypTdBqu.jpg', b'1', 'When a tech blogger lands an interview with a tech guru and stops an attack on him, he finds a mysterious ring that takes him back 57 seconds into the past.', '/dfS5qHWFuXyZQnwYREwb7N4qU5p.jpg', 5.4, '2023-09-29', '57 Seconds'),
('939335', '/eSsMzJpzAwCa69tm6Wco2il44aJ.jpg', b'1', 'LAPD K-9 officer Jake Rosser has just witnessed the shocking murder of his dedicated partner by a mysterious assailant. As he investigates the shooter’s identity, he uncovers a vast conspiracy that has a chokehold on the city in this thrilling journey through the tangled streets of Los Angeles and the corrupt bureaucracy of the LAPD.', '/qXChf7MFL36BgoLkiB3BzXiwW82.jpg', 6.2, '2023-09-29', 'Muzzle'),
('940241', '/qbWtbhoKtqta3rQDOe5ed80oB1X.jpg', b'0', 'A hijacked 767 will crash in just 97 minutes when its fuel runs out. Against the strong will of NSA Deputy Toyin, NSA Director Hawkins prepares to have the plane shot down before it does any catastrophic damage on the ground, leaving the fate of the innocent passengers in the hands of Tyler, one of the alleged hijackers on board who is an undercover Interpol agent - or is he?', '/eYGyR8xF8emNs9AJAJSyLXu56kR.jpg', 4.8, '2023-06-09', '97 Minutes'),
('951491', '/dZbLqRjjiiNCpTYzhzL2NMvz4J0.jpg', b'1', 'Between the events of \'Saw\' and \'Saw II\', a sick and desperate John Kramer travels to Mexico for a risky and experimental medical procedure in hopes of a miracle cure for his cancer, only to discover the entire operation is a scam to defraud the most vulnerable. Armed with a newfound purpose, the infamous serial killer returns to his work, turning the tables on the con artists in his signature visceral way through devious, deranged, and ingenious traps.', '/b16RAVwj2QN6RAs752UJNzQ9Of0.jpg', 7.3, '2023-09-26', 'Saw X'),
('958006', '/xHqTnPtpd9Qd7R0fVtoqxZYM67Q.jpg', b'1', 'A hitman, his boss, an art dealer and a money-laundering scheme that accidentally turns the assassin into an overnight avant-garde sensation, one that forces her to play the art world against the underworld.', '/qKpdy7N6zX05eisopvvviiTwPxb.jpg', 5.5, '2023-09-14', 'The Kill Room'),
('968051', '/mRGmNnh6pBAGGp6fMBMwI8iTBUO.jpg', b'1', 'In 1956 France, a priest is violently murdered, and Sister Irene begins to investigate. She once again comes face-to-face with a powerful evil.', '/5gzzkR7y3hnY8AD1wXjCnVlHba5.jpg', 7, '2023-09-06', 'The Nun II'),
('980489', '/r7DuyYJ0N3cD8bRKsR5Ygq2P7oa.jpg', b'1', 'The ultimate wish-fulfillment tale of a teenage Gran Turismo player whose gaming skills won him a series of Nissan competitions to become an actual professional racecar driver.', '/51tqzRtKMMZEYUpSYkrUE7v9ehm.jpg', 8.1, '2023-08-09', 'Gran Turismo');

-- --------------------------------------------------------

--
-- Table structure for table `movie_genres`
--

CREATE TABLE `movie_genres` (
  `movie_movie_id` varchar(255) NOT NULL,
  `genres_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie_genres`
--

INSERT INTO `movie_genres` (`movie_movie_id`, `genres_id`) VALUES
('299054', 28),
('299054', 12),
('299054', 53),
('926393', 28),
('926393', 53),
('926393', 80),
('968051', 27),
('968051', 9648),
('968051', 53),
('980489', 12),
('980489', 28),
('980489', 18),
('937249', 53),
('937249', 878),
('937249', 28),
('565770', 28),
('565770', 878),
('565770', 12),
('951491', 27),
('951491', 53),
('939335', 28),
('939335', 80),
('939335', 18),
('939335', 53),
('346698', 35),
('346698', 12),
('346698', 14),
('762430', 28),
('762430', 53),
('762430', 80),
('958006', 80),
('958006', 53),
('958006', 28),
('732684', 28),
('732684', 12),
('675531', 27),
('675531', 14),
('675531', 53),
('807172', 27),
('603692', 28),
('603692', 53),
('603692', 80),
('678512', 28),
('678512', 18),
('1008042', 27),
('1008042', 53),
('893723', 16),
('893723', 10751),
('893723', 28),
('893723', 878),
('466420', 80),
('466420', 18),
('466420', 53),
('1024773', 27),
('1024773', 9648),
('507089', 27),
('507089', 53),
('1058694', 18),
('502345', 16),
('502345', 12),
('1047041', 16),
('1047041', 28),
('1047041', 80),
('1047041', 9648),
('496450', 16),
('496450', 10751),
('496450', 28),
('496450', 14),
('496450', 10749),
('901362', 16),
('901362', 10751),
('901362', 10402),
('901362', 14),
('901362', 35),
('1160164', 10402),
('814776', 35),
('940241', 53),
('940241', 28),
('663712', 27),
('663712', 53),
('609681', 28),
('609681', 12),
('609681', 878),
('508883', 16),
('508883', 12),
('508883', 14),
('508883', 18),
('915935', 18),
('915935', 80),
('915935', 9648),
('666277', 18),
('666277', 10749),
('808396', 28),
('808396', 80),
('808396', 27);

-- --------------------------------------------------------

--
-- Table structure for table `movie_room`
--

CREATE TABLE `movie_room` (
  `room_id` int(11) NOT NULL,
  `available` bit(1) NOT NULL,
  `room_num` int(11) NOT NULL,
  `fk_cinema_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie_room`
--

INSERT INTO `movie_room` (`room_id`, `available`, `room_num`, `fk_cinema_id`) VALUES
(1, b'1', 1, 1),
(2, b'1', 2, 1),
(3, b'1', 3, 1),
(4, b'1', 4, 1),
(5, b'1', 5, 1),
(6, b'1', 6, 1),
(7, b'1', 7, 1),
(8, b'1', 8, 1),
(9, b'1', 9, 1),
(10, b'1', 10, 1),
(11, b'1', 11, 1),
(12, b'1', 12, 1),
(13, b'1', 13, 1),
(14, b'1', 14, 1),
(15, b'1', 15, 1),
(16, b'1', 16, 1),
(17, b'1', 17, 1),
(18, b'1', 18, 1),
(19, b'1', 19, 1),
(20, b'1', 20, 1);

-- --------------------------------------------------------

--
-- Table structure for table `movie_show`
--

CREATE TABLE `movie_show` (
  `show_id` int(11) NOT NULL,
  `date_created` date DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `movie_id` varchar(255) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie_show`
--

INSERT INTO `movie_show` (`show_id`, `date_created`, `start_time`, `movie_id`, `room_id`) VALUES
(1, '2023-10-30', '17:30', '299054', 1),
(2, '2023-10-30', '17:30', '346698', 2),
(3, '2023-10-30', '17:30', '565770', 3),
(4, '2023-10-30', '17:30', '603692', 4),
(5, '2023-10-30', '17:30', '675531', 5),
(6, '2023-10-30', '17:30', '732684', 6),
(7, '2023-10-30', '17:30', '762430', 7),
(8, '2023-10-30', '17:30', '807172', 8),
(9, '2023-10-30', '17:30', '926393', 9),
(10, '2023-10-30', '17:30', '937249', 10),
(11, '2023-10-30', '17:30', '939335', 11),
(12, '2023-10-30', '17:30', '951491', 12),
(13, '2023-10-30', '17:30', '958006', 13),
(14, '2023-10-30', '17:30', '968051', 14),
(15, '2023-10-30', '17:30', '980489', 15);

-- --------------------------------------------------------

--
-- Table structure for table `reserved_seat`
--

CREATE TABLE `reserved_seat` (
  `movie_show_show_id` int(11) NOT NULL,
  `seat_seat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reserved_seat`
--

INSERT INTO `reserved_seat` (`movie_show_show_id`, `seat_seat_id`) VALUES
(2, 39),
(2, 40),
(2, 44),
(2, 49),
(2, 50),
(2, 60),
(3, 61),
(3, 62);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `seat_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `seat_num` int(11) NOT NULL,
  `fk_room_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`seat_id`, `price`, `seat_num`, `fk_room_id`) VALUES
(1, 250, 1, 1),
(2, 250, 2, 1),
(3, 250, 3, 1),
(4, 250, 4, 1),
(5, 250, 5, 1),
(6, 250, 6, 1),
(7, 250, 7, 1),
(8, 250, 8, 1),
(9, 250, 9, 1),
(10, 250, 10, 1),
(11, 250, 11, 1),
(12, 250, 12, 1),
(13, 250, 13, 1),
(14, 250, 14, 1),
(15, 250, 15, 1),
(16, 250, 16, 1),
(17, 250, 17, 1),
(18, 250, 18, 1),
(19, 250, 19, 1),
(20, 250, 20, 1),
(21, 250, 21, 1),
(22, 250, 22, 1),
(23, 250, 23, 1),
(24, 250, 24, 1),
(25, 250, 25, 1),
(26, 250, 26, 1),
(27, 250, 27, 1),
(28, 250, 28, 1),
(29, 250, 29, 1),
(30, 250, 30, 1),
(31, 250, 1, 2),
(32, 250, 2, 2),
(33, 250, 3, 2),
(34, 250, 4, 2),
(35, 250, 5, 2),
(36, 250, 6, 2),
(37, 250, 7, 2),
(38, 250, 8, 2),
(39, 250, 9, 2),
(40, 250, 10, 2),
(41, 250, 11, 2),
(42, 250, 12, 2),
(43, 250, 13, 2),
(44, 250, 14, 2),
(45, 250, 15, 2),
(46, 250, 16, 2),
(47, 250, 17, 2),
(48, 250, 18, 2),
(49, 250, 19, 2),
(50, 250, 20, 2),
(51, 250, 21, 2),
(52, 250, 22, 2),
(53, 250, 23, 2),
(54, 250, 24, 2),
(55, 250, 25, 2),
(56, 250, 26, 2),
(57, 250, 27, 2),
(58, 250, 28, 2),
(59, 250, 29, 2),
(60, 250, 30, 2),
(61, 250, 1, 3),
(62, 250, 2, 3),
(63, 250, 3, 3),
(64, 250, 4, 3),
(65, 250, 5, 3),
(66, 250, 6, 3),
(67, 250, 7, 3),
(68, 250, 8, 3),
(69, 250, 9, 3),
(70, 250, 10, 3),
(71, 250, 11, 3),
(72, 250, 12, 3),
(73, 250, 13, 3),
(74, 250, 14, 3),
(75, 250, 15, 3),
(76, 250, 16, 3),
(77, 250, 17, 3),
(78, 250, 18, 3),
(79, 250, 19, 3),
(80, 250, 20, 3),
(81, 250, 21, 3),
(82, 250, 22, 3),
(83, 250, 23, 3),
(84, 250, 24, 3),
(85, 250, 25, 3),
(86, 250, 26, 3),
(87, 250, 27, 3),
(88, 250, 28, 3),
(89, 250, 29, 3),
(90, 250, 30, 3),
(91, 250, 1, 4),
(92, 250, 2, 4),
(93, 250, 3, 4),
(94, 250, 4, 4),
(95, 250, 5, 4),
(96, 250, 6, 4),
(97, 250, 7, 4),
(98, 250, 8, 4),
(99, 250, 9, 4),
(100, 250, 10, 4),
(101, 250, 11, 4),
(102, 250, 12, 4),
(103, 250, 13, 4),
(104, 250, 14, 4),
(105, 250, 15, 4),
(106, 250, 16, 4),
(107, 250, 17, 4),
(108, 250, 18, 4),
(109, 250, 19, 4),
(110, 250, 20, 4),
(111, 250, 21, 4),
(112, 250, 22, 4),
(113, 250, 23, 4),
(114, 250, 24, 4),
(115, 250, 25, 4),
(116, 250, 26, 4),
(117, 250, 27, 4),
(118, 250, 28, 4),
(119, 250, 29, 4),
(120, 250, 30, 4),
(121, 250, 1, 5),
(122, 250, 2, 5),
(123, 250, 3, 5),
(124, 250, 4, 5),
(125, 250, 5, 5),
(126, 250, 6, 5),
(127, 250, 7, 5),
(128, 250, 8, 5),
(129, 250, 9, 5),
(130, 250, 10, 5),
(131, 250, 11, 5),
(132, 250, 12, 5),
(133, 250, 13, 5),
(134, 250, 14, 5),
(135, 250, 15, 5),
(136, 250, 16, 5),
(137, 250, 17, 5),
(138, 250, 18, 5),
(139, 250, 19, 5),
(140, 250, 20, 5),
(141, 250, 21, 5),
(142, 250, 22, 5),
(143, 250, 23, 5),
(144, 250, 24, 5),
(145, 250, 25, 5),
(146, 250, 26, 5),
(147, 250, 27, 5),
(148, 250, 28, 5),
(149, 250, 29, 5),
(150, 250, 30, 5),
(151, 250, 1, 6),
(152, 250, 2, 6),
(153, 250, 3, 6),
(154, 250, 4, 6),
(155, 250, 5, 6),
(156, 250, 6, 6),
(157, 250, 7, 6),
(158, 250, 8, 6),
(159, 250, 9, 6),
(160, 250, 10, 6),
(161, 250, 11, 6),
(162, 250, 12, 6),
(163, 250, 13, 6),
(164, 250, 14, 6),
(165, 250, 15, 6),
(166, 250, 16, 6),
(167, 250, 17, 6),
(168, 250, 18, 6),
(169, 250, 19, 6),
(170, 250, 20, 6),
(171, 250, 21, 6),
(172, 250, 22, 6),
(173, 250, 23, 6),
(174, 250, 24, 6),
(175, 250, 25, 6),
(176, 250, 26, 6),
(177, 250, 27, 6),
(178, 250, 28, 6),
(179, 250, 29, 6),
(180, 250, 30, 6),
(181, 250, 1, 7),
(182, 250, 2, 7),
(183, 250, 3, 7),
(184, 250, 4, 7),
(185, 250, 5, 7),
(186, 250, 6, 7),
(187, 250, 7, 7),
(188, 250, 8, 7),
(189, 250, 9, 7),
(190, 250, 10, 7),
(191, 250, 11, 7),
(192, 250, 12, 7),
(193, 250, 13, 7),
(194, 250, 14, 7),
(195, 250, 15, 7),
(196, 250, 16, 7),
(197, 250, 17, 7),
(198, 250, 18, 7),
(199, 250, 19, 7),
(200, 250, 20, 7),
(201, 250, 21, 7),
(202, 250, 22, 7),
(203, 250, 23, 7),
(204, 250, 24, 7),
(205, 250, 25, 7),
(206, 250, 26, 7),
(207, 250, 27, 7),
(208, 250, 28, 7),
(209, 250, 29, 7),
(210, 250, 30, 7),
(211, 250, 1, 8),
(212, 250, 2, 8),
(213, 250, 3, 8),
(214, 250, 4, 8),
(215, 250, 5, 8),
(216, 250, 6, 8),
(217, 250, 7, 8),
(218, 250, 8, 8),
(219, 250, 9, 8),
(220, 250, 10, 8),
(221, 250, 11, 8),
(222, 250, 12, 8),
(223, 250, 13, 8),
(224, 250, 14, 8),
(225, 250, 15, 8),
(226, 250, 16, 8),
(227, 250, 17, 8),
(228, 250, 18, 8),
(229, 250, 19, 8),
(230, 250, 20, 8),
(231, 250, 21, 8),
(232, 250, 22, 8),
(233, 250, 23, 8),
(234, 250, 24, 8),
(235, 250, 25, 8),
(236, 250, 26, 8),
(237, 250, 27, 8),
(238, 250, 28, 8),
(239, 250, 29, 8),
(240, 250, 30, 8),
(241, 250, 1, 9),
(242, 250, 2, 9),
(243, 250, 3, 9),
(244, 250, 4, 9),
(245, 250, 5, 9),
(246, 250, 6, 9),
(247, 250, 7, 9),
(248, 250, 8, 9),
(249, 250, 9, 9),
(250, 250, 10, 9),
(251, 250, 11, 9),
(252, 250, 12, 9),
(253, 250, 13, 9),
(254, 250, 14, 9),
(255, 250, 15, 9),
(256, 250, 16, 9),
(257, 250, 17, 9),
(258, 250, 18, 9),
(259, 250, 19, 9),
(260, 250, 20, 9),
(261, 250, 21, 9),
(262, 250, 22, 9),
(263, 250, 23, 9),
(264, 250, 24, 9),
(265, 250, 25, 9),
(266, 250, 26, 9),
(267, 250, 27, 9),
(268, 250, 28, 9),
(269, 250, 29, 9),
(270, 250, 30, 9),
(271, 250, 1, 10),
(272, 250, 2, 10),
(273, 250, 3, 10),
(274, 250, 4, 10),
(275, 250, 5, 10),
(276, 250, 6, 10),
(277, 250, 7, 10),
(278, 250, 8, 10),
(279, 250, 9, 10),
(280, 250, 10, 10),
(281, 250, 11, 10),
(282, 250, 12, 10),
(283, 250, 13, 10),
(284, 250, 14, 10),
(285, 250, 15, 10),
(286, 250, 16, 10),
(287, 250, 17, 10),
(288, 250, 18, 10),
(289, 250, 19, 10),
(290, 250, 20, 10),
(291, 250, 21, 10),
(292, 250, 22, 10),
(293, 250, 23, 10),
(294, 250, 24, 10),
(295, 250, 25, 10),
(296, 250, 26, 10),
(297, 250, 27, 10),
(298, 250, 28, 10),
(299, 250, 29, 10),
(300, 250, 30, 10),
(301, 250, 1, 11),
(302, 250, 2, 11),
(303, 250, 3, 11),
(304, 250, 4, 11),
(305, 250, 5, 11),
(306, 250, 6, 11),
(307, 250, 7, 11),
(308, 250, 8, 11),
(309, 250, 9, 11),
(310, 250, 10, 11),
(311, 250, 11, 11),
(312, 250, 12, 11),
(313, 250, 13, 11),
(314, 250, 14, 11),
(315, 250, 15, 11),
(316, 250, 16, 11),
(317, 250, 17, 11),
(318, 250, 18, 11),
(319, 250, 19, 11),
(320, 250, 20, 11),
(321, 250, 21, 11),
(322, 250, 22, 11),
(323, 250, 23, 11),
(324, 250, 24, 11),
(325, 250, 25, 11),
(326, 250, 26, 11),
(327, 250, 27, 11),
(328, 250, 28, 11),
(329, 250, 29, 11),
(330, 250, 30, 11),
(331, 250, 1, 12),
(332, 250, 2, 12),
(333, 250, 3, 12),
(334, 250, 4, 12),
(335, 250, 5, 12),
(336, 250, 6, 12),
(337, 250, 7, 12),
(338, 250, 8, 12),
(339, 250, 9, 12),
(340, 250, 10, 12),
(341, 250, 11, 12),
(342, 250, 12, 12),
(343, 250, 13, 12),
(344, 250, 14, 12),
(345, 250, 15, 12),
(346, 250, 16, 12),
(347, 250, 17, 12),
(348, 250, 18, 12),
(349, 250, 19, 12),
(350, 250, 20, 12),
(351, 250, 21, 12),
(352, 250, 22, 12),
(353, 250, 23, 12),
(354, 250, 24, 12),
(355, 250, 25, 12),
(356, 250, 26, 12),
(357, 250, 27, 12),
(358, 250, 28, 12),
(359, 250, 29, 12),
(360, 250, 30, 12),
(361, 250, 1, 13),
(362, 250, 2, 13),
(363, 250, 3, 13),
(364, 250, 4, 13),
(365, 250, 5, 13),
(366, 250, 6, 13),
(367, 250, 7, 13),
(368, 250, 8, 13),
(369, 250, 9, 13),
(370, 250, 10, 13),
(371, 250, 11, 13),
(372, 250, 12, 13),
(373, 250, 13, 13),
(374, 250, 14, 13),
(375, 250, 15, 13),
(376, 250, 16, 13),
(377, 250, 17, 13),
(378, 250, 18, 13),
(379, 250, 19, 13),
(380, 250, 20, 13),
(381, 250, 21, 13),
(382, 250, 22, 13),
(383, 250, 23, 13),
(384, 250, 24, 13),
(385, 250, 25, 13),
(386, 250, 26, 13),
(387, 250, 27, 13),
(388, 250, 28, 13),
(389, 250, 29, 13),
(390, 250, 30, 13),
(391, 250, 1, 14),
(392, 250, 2, 14),
(393, 250, 3, 14),
(394, 250, 4, 14),
(395, 250, 5, 14),
(396, 250, 6, 14),
(397, 250, 7, 14),
(398, 250, 8, 14),
(399, 250, 9, 14),
(400, 250, 10, 14),
(401, 250, 11, 14),
(402, 250, 12, 14),
(403, 250, 13, 14),
(404, 250, 14, 14),
(405, 250, 15, 14),
(406, 250, 16, 14),
(407, 250, 17, 14),
(408, 250, 18, 14),
(409, 250, 19, 14),
(410, 250, 20, 14),
(411, 250, 21, 14),
(412, 250, 22, 14),
(413, 250, 23, 14),
(414, 250, 24, 14),
(415, 250, 25, 14),
(416, 250, 26, 14),
(417, 250, 27, 14),
(418, 250, 28, 14),
(419, 250, 29, 14),
(420, 250, 30, 14),
(421, 250, 1, 15),
(422, 250, 2, 15),
(423, 250, 3, 15),
(424, 250, 4, 15),
(425, 250, 5, 15),
(426, 250, 6, 15),
(427, 250, 7, 15),
(428, 250, 8, 15),
(429, 250, 9, 15),
(430, 250, 10, 15),
(431, 250, 11, 15),
(432, 250, 12, 15),
(433, 250, 13, 15),
(434, 250, 14, 15),
(435, 250, 15, 15),
(436, 250, 16, 15),
(437, 250, 17, 15),
(438, 250, 18, 15),
(439, 250, 19, 15),
(440, 250, 20, 15),
(441, 250, 21, 15),
(442, 250, 22, 15),
(443, 250, 23, 15),
(444, 250, 24, 15),
(445, 250, 25, 15),
(446, 250, 26, 15),
(447, 250, 27, 15),
(448, 250, 28, 15),
(449, 250, 29, 15),
(450, 250, 30, 15),
(451, 250, 1, 16),
(452, 250, 2, 16),
(453, 250, 3, 16),
(454, 250, 4, 16),
(455, 250, 5, 16),
(456, 250, 6, 16),
(457, 250, 7, 16),
(458, 250, 8, 16),
(459, 250, 9, 16),
(460, 250, 10, 16),
(461, 250, 11, 16),
(462, 250, 12, 16),
(463, 250, 13, 16),
(464, 250, 14, 16),
(465, 250, 15, 16),
(466, 250, 16, 16),
(467, 250, 17, 16),
(468, 250, 18, 16),
(469, 250, 19, 16),
(470, 250, 20, 16),
(471, 250, 21, 16),
(472, 250, 22, 16),
(473, 250, 23, 16),
(474, 250, 24, 16),
(475, 250, 25, 16),
(476, 250, 26, 16),
(477, 250, 27, 16),
(478, 250, 28, 16),
(479, 250, 29, 16),
(480, 250, 30, 16),
(481, 250, 1, 17),
(482, 250, 2, 17),
(483, 250, 3, 17),
(484, 250, 4, 17),
(485, 250, 5, 17),
(486, 250, 6, 17),
(487, 250, 7, 17),
(488, 250, 8, 17),
(489, 250, 9, 17),
(490, 250, 10, 17),
(491, 250, 11, 17),
(492, 250, 12, 17),
(493, 250, 13, 17),
(494, 250, 14, 17),
(495, 250, 15, 17),
(496, 250, 16, 17),
(497, 250, 17, 17),
(498, 250, 18, 17),
(499, 250, 19, 17),
(500, 250, 20, 17),
(501, 250, 21, 17),
(502, 250, 22, 17),
(503, 250, 23, 17),
(504, 250, 24, 17),
(505, 250, 25, 17),
(506, 250, 26, 17),
(507, 250, 27, 17),
(508, 250, 28, 17),
(509, 250, 29, 17),
(510, 250, 30, 17),
(511, 250, 1, 18),
(512, 250, 2, 18),
(513, 250, 3, 18),
(514, 250, 4, 18),
(515, 250, 5, 18),
(516, 250, 6, 18),
(517, 250, 7, 18),
(518, 250, 8, 18),
(519, 250, 9, 18),
(520, 250, 10, 18),
(521, 250, 11, 18),
(522, 250, 12, 18),
(523, 250, 13, 18),
(524, 250, 14, 18),
(525, 250, 15, 18),
(526, 250, 16, 18),
(527, 250, 17, 18),
(528, 250, 18, 18),
(529, 250, 19, 18),
(530, 250, 20, 18),
(531, 250, 21, 18),
(532, 250, 22, 18),
(533, 250, 23, 18),
(534, 250, 24, 18),
(535, 250, 25, 18),
(536, 250, 26, 18),
(537, 250, 27, 18),
(538, 250, 28, 18),
(539, 250, 29, 18),
(540, 250, 30, 18),
(541, 250, 1, 19),
(542, 250, 2, 19),
(543, 250, 3, 19),
(544, 250, 4, 19),
(545, 250, 5, 19),
(546, 250, 6, 19),
(547, 250, 7, 19),
(548, 250, 8, 19),
(549, 250, 9, 19),
(550, 250, 10, 19),
(551, 250, 11, 19),
(552, 250, 12, 19),
(553, 250, 13, 19),
(554, 250, 14, 19),
(555, 250, 15, 19),
(556, 250, 16, 19),
(557, 250, 17, 19),
(558, 250, 18, 19),
(559, 250, 19, 19),
(560, 250, 20, 19),
(561, 250, 21, 19),
(562, 250, 22, 19),
(563, 250, 23, 19),
(564, 250, 24, 19),
(565, 250, 25, 19),
(566, 250, 26, 19),
(567, 250, 27, 19),
(568, 250, 28, 19),
(569, 250, 29, 19),
(570, 250, 30, 19),
(571, 250, 1, 20),
(572, 250, 2, 20),
(573, 250, 3, 20),
(574, 250, 4, 20),
(575, 250, 5, 20),
(576, 250, 6, 20),
(577, 250, 7, 20),
(578, 250, 8, 20),
(579, 250, 9, 20),
(580, 250, 10, 20),
(581, 250, 11, 20),
(582, 250, 12, 20),
(583, 250, 13, 20),
(584, 250, 14, 20),
(585, 250, 15, 20),
(586, 250, 16, 20),
(587, 250, 17, 20),
(588, 250, 18, 20),
(589, 250, 19, 20),
(590, 250, 20, 20),
(591, 250, 21, 20),
(592, 250, 22, 20),
(593, 250, 23, 20),
(594, 250, 24, 20),
(595, 250, 25, 20),
(596, 250, 26, 20),
(597, 250, 27, 20),
(598, 250, 28, 20),
(599, 250, 29, 20),
(600, 250, 30, 20);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `name`, `password`, `phone`, `surname`) VALUES
(1, 'sbani@gmail.com', 'Sbani', '12345', '07699690157', 'Sithole'),
(2, 'sbani@gmail.com', 'User 1', NULL, '0987897787', 'Surname1'),
(3, 'sbani2@gmail.com', 'User 1', '1234567890', '0987897787', 'Surname1'),
(4, '219446563@mycput.ac.za', 'Sbani', '$2b$13$QFrF720R0dqCQOVg/9lrUubP1o49oE5K7poQbD0BqQyvnRFPCRKw2', '0769690193', 'Surname1'),
(5, 'sbanintokozo99@gmail.com', 'Sbani', '$2b$13$s/erM3dNloW/VzSvfAExBOMLHCbtYlq24xqGPi18heBrw7yXjii8O', '0769690198', 'Sithole');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`street`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `FKr76734xxjo7trp0ocvyh108q5` (`movie_show_show_id`);

--
-- Indexes for table `booking_seats`
--
ALTER TABLE `booking_seats`
  ADD UNIQUE KEY `UK_pwkq7j5icht40gun72sj7q2ng` (`seats_seat_id`),
  ADD KEY `FKleba1cxp17xopiiw80pjihvw5` (`booking_booking_id`);

--
-- Indexes for table `cinema`
--
ALTER TABLE `cinema`
  ADD PRIMARY KEY (`cinema_id`);

--
-- Indexes for table `coupon`
--
ALTER TABLE `coupon`
  ADD PRIMARY KEY (`coupon_id`),
  ADD KEY `FK4j88wk1cgbrm32o5kmxqhlln6` (`user_id_user_id`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`),
  ADD UNIQUE KEY `UK_2duark7f3riw2tle4yknw3pjg` (`user_user_id`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movie_id`);

--
-- Indexes for table `movie_genres`
--
ALTER TABLE `movie_genres`
  ADD KEY `FKi8gl10taq0yvv0aqnuxeal5x0` (`genres_id`),
  ADD KEY `FKla8n7x0y9g651yl82r8cp5rdn` (`movie_movie_id`);

--
-- Indexes for table `movie_room`
--
ALTER TABLE `movie_room`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `FK6dwda835c9pwygbeidplp3sa4` (`fk_cinema_id`);

--
-- Indexes for table `movie_show`
--
ALTER TABLE `movie_show`
  ADD PRIMARY KEY (`show_id`),
  ADD KEY `FKsp1joejd7rlqf48cg5nff615p` (`movie_id`),
  ADD KEY `FKr2ypmef8y0paf2j3h79sc9l6g` (`room_id`);

--
-- Indexes for table `reserved_seat`
--
ALTER TABLE `reserved_seat`
  ADD PRIMARY KEY (`movie_show_show_id`,`seat_seat_id`),
  ADD KEY `FKls3h6tqg7kyao6t2j2p9fke3i` (`seat_seat_id`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`seat_id`),
  ADD KEY `FK3txfk5wncb4g9ewktvvanfd0l` (`fk_room_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `cinema`
--
ALTER TABLE `cinema`
  MODIFY `cinema_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `movie_room`
--
ALTER TABLE `movie_room`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `movie_show`
--
ALTER TABLE `movie_show`
  MODIFY `show_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `seat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=601;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `FKr76734xxjo7trp0ocvyh108q5` FOREIGN KEY (`movie_show_show_id`) REFERENCES `movie_show` (`show_id`);

--
-- Constraints for table `booking_seats`
--
ALTER TABLE `booking_seats`
  ADD CONSTRAINT `FK1tydaanbpevjbxrf4d243rumt` FOREIGN KEY (`seats_seat_id`) REFERENCES `seat` (`seat_id`),
  ADD CONSTRAINT `FKleba1cxp17xopiiw80pjihvw5` FOREIGN KEY (`booking_booking_id`) REFERENCES `booking` (`booking_id`);

--
-- Constraints for table `coupon`
--
ALTER TABLE `coupon`
  ADD CONSTRAINT `FK4j88wk1cgbrm32o5kmxqhlln6` FOREIGN KEY (`user_id_user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `FK4e4xgu7vgxic5grv381s3rgoo` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `movie_genres`
--
ALTER TABLE `movie_genres`
  ADD CONSTRAINT `FKi8gl10taq0yvv0aqnuxeal5x0` FOREIGN KEY (`genres_id`) REFERENCES `genre` (`id`),
  ADD CONSTRAINT `FKla8n7x0y9g651yl82r8cp5rdn` FOREIGN KEY (`movie_movie_id`) REFERENCES `movie` (`movie_id`);

--
-- Constraints for table `movie_room`
--
ALTER TABLE `movie_room`
  ADD CONSTRAINT `FK6dwda835c9pwygbeidplp3sa4` FOREIGN KEY (`fk_cinema_id`) REFERENCES `cinema` (`cinema_id`);

--
-- Constraints for table `movie_show`
--
ALTER TABLE `movie_show`
  ADD CONSTRAINT `FKr2ypmef8y0paf2j3h79sc9l6g` FOREIGN KEY (`room_id`) REFERENCES `movie_room` (`room_id`),
  ADD CONSTRAINT `FKsp1joejd7rlqf48cg5nff615p` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`);

--
-- Constraints for table `reserved_seat`
--
ALTER TABLE `reserved_seat`
  ADD CONSTRAINT `FK3ygbey30xsbmsixuvvw3yh3ho` FOREIGN KEY (`movie_show_show_id`) REFERENCES `movie_show` (`show_id`),
  ADD CONSTRAINT `FKls3h6tqg7kyao6t2j2p9fke3i` FOREIGN KEY (`seat_seat_id`) REFERENCES `seat` (`seat_id`);

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `FK3txfk5wncb4g9ewktvvanfd0l` FOREIGN KEY (`fk_room_id`) REFERENCES `movie_room` (`room_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
