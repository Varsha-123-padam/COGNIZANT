-- Step 1: Create the database if it doesn't exist
CREATE DATABASE IF NOT EXISTS event_management;

-- Step 2: Use the database
USE event_management;

-- Step 3: Create Tables

-- 1. Users Table
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

-- 2. Events Table
CREATE TABLE Events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming', 'completed', 'cancelled') NOT NULL,
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

-- 3. Sessions Table
CREATE TABLE Sessions (
    session_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- 4. Registrations Table
CREATE TABLE Registrations (
    registration_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- 5. Feedback Table
CREATE TABLE Feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- 6. Resources Table
CREATE TABLE Resources (
    resource_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT,
    resource_type ENUM('pdf', 'image', 'link') NOT NULL,
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Step 4: Insert Data

-- Users
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES
(1, 'Alice Johnson', 'alice@example.com', 'New York', '2024-12-01'),
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');

-- Events
INSERT INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES
(1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3),
(3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

-- Sessions
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES
(1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

-- Registrations
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES
(1, 1, 1, '2025-05-01'),
(2, 2, 1, '2025-05-02'),
(3, 3, 2, '2025-04-30'),
(4, 4, 2, '2025-04-28'),
(5, 5, 3, '2025-06-15');

-- Feedback
INSERT INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES
(1, 3, 2, 4, 'Great insights!', '2025-05-16'),
(2, 4, 2, 5, 'Very informative.', '2025-05-16'),
(3, 2, 1, 3, 'Could be better.', '2025-06-11');

-- Resources
INSERT INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 2, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');

SELECT 
    u.full_name,
    e.title AS event_title,
    e.city AS event_city,
    e.start_date
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
JOIN Events e ON r.event_id = e.event_id
WHERE 
    e.start_date > NOW()        -- Upcoming events only
    AND u.city = e.city         -- Event in user's city
ORDER BY 
    e.start_date;

SELECT 
    e.title AS event_title,
    AVG(f.rating) AS average_rating,
    COUNT(f.feedback_id) AS feedback_count
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id
HAVING COUNT(f.feedback_id) >= 10
ORDER BY average_rating DESC;

SELECT u.user_id, u.full_name, u.email, u.registration_date
FROM Users u
LEFT JOIN Registrations r 
  ON u.user_id = r.user_id 
  AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
WHERE r.registration_id IS NULL;

SELECT 
    e.title AS event_title,
    COUNT(s.session_id) AS session_count_between_10_to_12
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
WHERE 
    TIME(s.start_time) >= '10:00:00'
    AND TIME(s.start_time) < '12:00:00'
GROUP BY e.event_id, e.title;

SELECT 
    u.city,
    COUNT(DISTINCT r.user_id) AS distinct_user_registrations
FROM Users u
JOIN Registrations r ON u.user_id = r.user_id
GROUP BY u.city
ORDER BY distinct_user_registrations DESC
LIMIT 5;

SELECT 
    e.title AS event_title,
    SUM(CASE WHEN r.resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
    SUM(CASE WHEN r.resource_type = 'image' THEN 1 ELSE 0 END) AS image_count,
    SUM(CASE WHEN r.resource_type = 'link' THEN 1 ELSE 0 END) AS link_count
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title;

SELECT 
    u.full_name AS user_name,
    u.email,
    e.title AS event_title,
    f.rating,
    f.comments
FROM Feedback f
JOIN Users u ON f.user_id = u.user_id
JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3;

SELECT 
    e.title AS event_title,
    COUNT(s.session_id) AS session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title;

SELECT 
    u.user_id,
    u.full_name AS organizer_name,
    COUNT(e.event_id) AS total_events,
    SUM(CASE WHEN e.status = 'upcoming' THEN 1 ELSE 0 END) AS upcoming_events,
    SUM(CASE WHEN e.status = 'completed' THEN 1 ELSE 0 END) AS completed_events,
    SUM(CASE WHEN e.status = 'cancelled' THEN 1 ELSE 0 END) AS cancelled_events
FROM Users u
LEFT JOIN Events e ON u.user_id = e.organizer_id
GROUP BY u.user_id, u.full_name
ORDER BY total_events DESC;

SELECT 
    e.event_id,
    e.title AS event_title
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(r.registration_id) > 0
   AND COUNT(f.feedback_id) = 0;

SELECT 
    registration_date,
    COUNT(user_id) AS new_user_count
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date
ORDER BY registration_date;

-- Get event(s) with the maximum number of sessions
SELECT 
    e.event_id,
    e.title AS event_title,
    COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
HAVING session_count = (
    SELECT MAX(session_counts) FROM (
        SELECT COUNT(session_id) AS session_counts
        FROM Sessions
        GROUP BY event_id
    ) AS counts
);

SELECT 
    e.city,
    AVG(f.rating) AS average_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.city
ORDER BY average_rating DESC;

SELECT 
    e.event_id,
    e.title AS event_title,
    COUNT(r.registration_id) AS total_registrations
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC
LIMIT 3;

SELECT 
    s1.event_id,
    s1.session_id AS session1_id,
    s1.title AS session1_title,
    s1.start_time AS session1_start,
    s1.end_time AS session1_end,
    s2.session_id AS session2_id,
    s2.title AS session2_title,
    s2.start_time AS session2_start,
    s2.end_time AS session2_end
FROM Sessions s1
JOIN Sessions s2 
    ON s1.event_id = s2.event_id
    AND s1.session_id < s2.session_id  -- avoid duplicate pairs and self-join
WHERE 
    s1.start_time < s2.end_time
    AND s2.start_time < s1.end_time
ORDER BY s1.event_id, s1.session_id, s2.session_id;

SELECT 
    u.user_id,
    u.full_name,
    u.email,
    u.registration_date
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
WHERE 
    u.registration_date >= CURDATE() - INTERVAL 30 DAY
    AND r.registration_id IS NULL;

SELECT 
    speaker_name,
    COUNT(session_id) AS session_count
FROM Sessions
GROUP BY speaker_name
HAVING session_count > 1
ORDER BY session_count DESC;

SELECT 
    e.event_id,
    e.title AS event_title
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;

SELECT
    e.event_id,
    e.title AS event_title,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    AVG(f.rating) AS average_rating
FROM Events e
LEFT JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE e.status = 'completed'
GROUP BY e.event_id, e.title
ORDER BY e.event_id;

SELECT
    u.user_id,
    u.full_name,
    COUNT(DISTINCT r.event_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_submitted
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
LEFT JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY u.user_id;

SELECT
    u.user_id,
    u.full_name,
    COUNT(f.feedback_id) AS feedback_count
FROM Users u
JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY feedback_count DESC
LIMIT 5;

SELECT
    user_id,
    event_id,
    COUNT(*) AS registration_count
FROM Registrations
GROUP BY user_id, event_id
HAVING registration_count > 1;

SELECT
    DATE_FORMAT(registration_date, '%Y-%m') AS year_month,
    COUNT(*) AS registrations_count
FROM
    Registrations
WHERE
    registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY
    DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY
    year_month;

SELECT
    e.event_id,
    e.title AS event_title,
    AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) AS avg_session_duration_minutes
FROM
    Events e
JOIN
    Sessions s ON e.event_id = s.event_id
GROUP BY
    e.event_id, e.title
ORDER BY
    avg_session_duration_minutes DESC;

SELECT
    e.event_id,
    e.title AS event_title,
    e.city,
    e.start_date,
    e.status
FROM
    Events e
LEFT JOIN
    Sessions s ON e.event_id = s.event_id
WHERE
    s.session_id IS NULL
ORDER BY
    e.start_date;










