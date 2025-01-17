---- ********   USER  ******
--INSERT INTO [dbo].[users] (created_at, email, first_name, last_name, password, username) VALUES (GETDATE(), 'will@example.com', 'Wilmer', 'Arango', 'password123', 'will');
--INSERT INTO [dbo].[users] (created_at, email, first_name, last_name, password, username) VALUES (GETDATE(), 'rick@example.com', 'Riccardo', 'Bertusi', 'password123', 'rick');
--
---- ********   VIDEO  ******
INSERT INTO [dbo].[videos] (title, file_path, thumbnail_url, duration_in_seconds, description, created_at) VALUES ('Titolo 2 del Video', '/videos/OneExpress.mp4', '/path/to/thumbnail.jpg', '1:25', 'Descrizione del video', GETDATE());
INSERT INTO [dbo].[videos] (title, file_path, thumbnail_url, duration_in_seconds, description, created_at) VALUES ('Titolo 1 del Video', '/videos/OneExpress.mp4', '/path/to/thumbnail.jpg', '1:25', 'Descrizione del video', GETDATE());
INSERT INTO [dbo].[videos] (title, file_path, thumbnail_url, duration_in_seconds, description, created_at) VALUES ('Titolo 3 del Video', '/videos/OneExpress.mp4', '/path/to/thumbnail.jpg', '1:25', 'Descrizione del video', GETDATE());
---- ********   PLAYLIST  ******
INSERT INTO [dbo].[playlists] (name) VALUES ('Playlist 1');
INSERT INTO [dbo].[playlists] (name) VALUES ('Playlist 2');
INSERT INTO [dbo].[playlists] (name) VALUES ('Playlist 3');

-- INSERT INTO [dbo].[videos] (created_at, description, title) VALUES (GETDATE(), 'Cansone di prova 1', 'Ti voglio a sai');
-- INSERT INTO [dbo].[videos] (created_at, description, title) VALUES (GETDATE(), 'Cansone di prova 2', 'Ti voglio a sai');
-- --INSERT INTO [dbo].[videos] (created_at, description, title) VALUES (GETDATE(), 'Cansone di prova 3', 'Ti voglio a sai');
-- --INSERT INTO [dbo].[videos] (created_at, description, title) VALUES (GETDATE(), 'Cansone di prova 4', 'Ti voglio a sai');
-- --INSERT INTO [dbo].[videos] (created_at, description, title) VALUES (GETDATE(), 'Cansone di prova 5', 'Ti voglio a sai');
---- ********   PLAYLIST  ******
--INSERT INTO [dbo].[playlists] (created_at, description, name) VALUES (GETDATE(), 'videos default ', 'Default');


-- ********   MariaDB "phpMyAdmin"  ******
-- ********   USER  ******
-- INSERT INTO users (created_at, email, first_name, last_name, password, username) VALUES (NOW(), 'will@example.com', 'Wilmer', 'Arango', 'password123', 'will');
-- INSERT INTO users (created_at, email, first_name, last_name, password, username) VALUES (NOW(), 'prova2@example.com', 'Wilmer', 'Arango', 'password123', 'will');
--
-- -- ********   VIDEO  ******
-- INSERT INTO videos (title, file_path, thumbnail_url, duration_in_seconds, description, created_at) VALUES ('Titolo 1 del Video', '/path/to/file.mp4', '/path/to/thumbnail.jpg', 300, 'Descrizione del video', NOW());
-- INSERT INTO videos (title, file_path, thumbnail_url, duration_in_seconds, description, created_at) VALUES ('Titolo 2 del Video', '/path/to/file.mp4', '/path/to/thumbnail.jpg', 300, 'Descrizione del video', NOW());
-- INSERT INTO videos (title, file_path, thumbnail_url, duration_in_seconds, description, created_at) VALUES ('Titolo 3 del Video', '/path/to/file.mp4', '/path/to/thumbnail.jpg', 300, 'Descrizione del video', NOW());
-- INSERT INTO videos (title, file_path, thumbnail_url, duration_in_seconds, description, created_at) VALUES ('Titolo 4 del Video', '/path/to/file.mp4', '/path/to/thumbnail.jpg', 300, 'Descrizione del video', NOW());
--
-- -- ********   PLAYLIST  ******
-- INSERT INTO playlists (created_at, description, name) VALUES (NOW(), 'videos default ', 'Default');

