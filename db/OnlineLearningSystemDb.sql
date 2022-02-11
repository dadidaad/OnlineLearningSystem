USE [master]
GO
/****** Object:  Database [OnlineLearningSystem]    Script Date: 2/7/2022 8:31:52 PM ******/
CREATE DATABASE [OnlineLearningSystem]
GO
ALTER DATABASE [OnlineLearningSystem] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OnlineLearningSystem].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OnlineLearningSystem] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET ARITHABORT OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OnlineLearningSystem] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OnlineLearningSystem] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET  ENABLE_BROKER 
GO
ALTER DATABASE [OnlineLearningSystem] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OnlineLearningSystem] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET RECOVERY FULL 
GO
ALTER DATABASE [OnlineLearningSystem] SET  MULTI_USER 
GO
ALTER DATABASE [OnlineLearningSystem] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OnlineLearningSystem] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OnlineLearningSystem] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OnlineLearningSystem] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [OnlineLearningSystem] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [OnlineLearningSystem] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'OnlineLearningSystem', N'ON'
GO
ALTER DATABASE [OnlineLearningSystem] SET QUERY_STORE = OFF
GO
USE [OnlineLearningSystem]
GO
/****** Object:  UserDefinedFunction [dbo].[ChkValidEmail]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[ChkValidEmail](@EMAIL varchar(100))RETURNS bit as
BEGIN     
  DECLARE @bitEmailVal as Bit
  DECLARE @EmailText varchar(100)

  SET @EmailText=ltrim(rtrim(isnull(@EMAIL,'')))

  SET @bitEmailVal = case when @EmailText = '' then 0
                          when @EmailText like '% %' then 0
                          when @EmailText like ('%["(),:;<>\]%') then 0
                          when substring(@EmailText,charindex('@',@EmailText),len(@EmailText)) like ('%[!#$%&*+/=?^`_{|]%') then 0
                          when (left(@EmailText,1) like ('[-_.+]') or right(@EmailText,1) like ('[-_.+]')) then 0                                                                                    
                          when (@EmailText like '%[%' or @EmailText like '%]%') then 0
                          when @EmailText LIKE '%@%@%' then 0
                          when @EmailText NOT LIKE '_%@_%._%' then 0
                          else 1 
                      end
  RETURN @bitEmailVal
END 
GO
/****** Object:  Table [dbo].[Account]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [varchar](30) NOT NULL,
	[Password] [varchar](30) NOT NULL,
	[Mail] [varchar](50) NOT NULL,
	[Avatar] [varchar](100) NULL,
	[DisplayName] [nvarchar](50) NULL,
	[DateOfBirth] [date] NULL,
	[Sex] [bit] NULL,
	[Description] [nvarchar](300) NULL,
	[Cash in account] [money] NOT NULL,
	[CreatedDate] [date] NOT NULL,
	[Role] [varchar](20) NOT NULL,
	[Status] [varchar](20) NOT NULL,
	[State] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Chapter]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chapter](
	[ChapterID] [int] IDENTITY(1,1) NOT NULL,
	[ChapterName] [nvarchar](100) NOT NULL,
	[Semester] [int] NULL,
	[Chapter Content] [nvarchar](300) NULL,
	[SubjectID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ChapterID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Characteristic_Term]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Characteristic_Term](
	[TermID] [int] IDENTITY(1,1) NOT NULL,
	[TermName] [nvarchar](50) NOT NULL,
	[Explain] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[TermID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Constant]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Constant](
	[ConstantID] [int] IDENTITY(1,1) NOT NULL,
	[ConstantName] [nvarchar](50) NOT NULL,
	[Value] [varchar](50) NULL,
	[Unit] [int] NULL,
	[SubjectID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ConstantID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Finance_History]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Finance_History](
	[UserGet] [varchar](30) NOT NULL,
	[Status] [bit] NOT NULL,
	[Money] [money] NOT NULL,
	[Time] [datetime] NOT NULL,
	[Message] [nvarchar](300) NULL,
	[UserSent] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserGet] ASC,
	[Time] ASC,
	[UserSent] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Knowledge]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Knowledge](
	[KnowledgeID] [int] IDENTITY(1,1) NOT NULL,
	[KnowledgeName] [nvarchar](100) NOT NULL,
	[Title] [nvarchar](200) NULL,
	[ChapterID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[KnowledgeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Notification]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notification](
	[NotificationID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](30) NULL,
	[Content] [nvarchar](200) NULL,
	[Time] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[NotificationID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post](
	[PostID] [int] IDENTITY(1,1) NOT NULL,
	[TopicID] [int] NOT NULL,
	[UserPost] [varchar](30) NOT NULL,
	[CreatedDate] [datetime] NOT NULL,
	[Title] [nvarchar](100) NOT NULL,
	[Body] [ntext] NOT NULL,
	[Status] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PostID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Post_Reply]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post_Reply](
	[Post_replyID] [int] IDENTITY(1,1) NOT NULL,
	[PostID] [int] NOT NULL,
	[User_reply] [varchar](30) NOT NULL,
	[CreatedDate] [datetime] NOT NULL,
	[Title] [nvarchar](100) NOT NULL,
	[Body] [ntext] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Post_replyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Request]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Request](
	[RequestID] [int] IDENTITY(1,1) NOT NULL,
	[Student_sent] [varchar](30) NOT NULL,
	[Tutor_get] [varchar](30) NULL,
	[CreatedTime] [datetime] NOT NULL,
	[Status] [varchar](50) NOT NULL,
	[Cost] [money] NOT NULL,
	[Content] [nvarchar](200) NOT NULL,
	[Image] [varchar](100) NULL,
	[SubjectID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RequestID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Request_Reply]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Request_Reply](
	[RequestID] [int] IDENTITY(1,1) NOT NULL,
	[Tutor_sent] [varchar](30) NOT NULL,
	[Student_get] [varchar](30) NOT NULL,
	[CreatedTime] [datetime] NOT NULL,
	[Content_reply] [nvarchar](200) NOT NULL,
	[Image_reply] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[RequestID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subject]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject](
	[SubjectID] [int] IDENTITY(1,1) NOT NULL,
	[SubjectName] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[SubjectID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Topic]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Topic](
	[TopicID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](100) NOT NULL,
	[SubjectID] [int] NOT NULL,
	[Date] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TopicID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tutor]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tutor](
	[Username] [varchar](30) NOT NULL,
	[CV] [varchar](100) NOT NULL,
	[SubjectID] [int] NOT NULL,
	[Status] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vote]    Script Date: 2/7/2022 8:31:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vote](
	[VoteID] [int] IDENTITY(1,1) NOT NULL,
	[User_sent] [varchar](30) NOT NULL,
	[User_get] [varchar](30) NOT NULL,
	[Stars] [int] NOT NULL,
	[Reason] [nvarchar](200) NULL,
	[RequestID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[VoteID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Chapter]  WITH CHECK ADD FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subject] ([SubjectID])
GO
ALTER TABLE [dbo].[Constant]  WITH CHECK ADD FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subject] ([SubjectID])
GO
ALTER TABLE [dbo].[Finance_History]  WITH CHECK ADD FOREIGN KEY([UserGet])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Finance_History]  WITH CHECK ADD FOREIGN KEY([UserSent])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Knowledge]  WITH CHECK ADD FOREIGN KEY([ChapterID])
REFERENCES [dbo].[Chapter] ([ChapterID])
GO
ALTER TABLE [dbo].[Notification]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD FOREIGN KEY([TopicID])
REFERENCES [dbo].[Topic] ([TopicID])
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD FOREIGN KEY([UserPost])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Post_Reply]  WITH CHECK ADD FOREIGN KEY([PostID])
REFERENCES [dbo].[Post] ([PostID])
GO
ALTER TABLE [dbo].[Post_Reply]  WITH CHECK ADD FOREIGN KEY([User_reply])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD FOREIGN KEY([Student_sent])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subject] ([SubjectID])
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD FOREIGN KEY([Tutor_get])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Request_Reply]  WITH CHECK ADD FOREIGN KEY([RequestID])
REFERENCES [dbo].[Request] ([RequestID])
GO
ALTER TABLE [dbo].[Request_Reply]  WITH CHECK ADD FOREIGN KEY([Student_get])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Request_Reply]  WITH CHECK ADD FOREIGN KEY([Tutor_sent])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Topic]  WITH CHECK ADD FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subject] ([SubjectID])
GO
ALTER TABLE [dbo].[Tutor]  WITH CHECK ADD FOREIGN KEY([SubjectID])
REFERENCES [dbo].[Subject] ([SubjectID])
GO
ALTER TABLE [dbo].[Tutor]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Vote]  WITH CHECK ADD FOREIGN KEY([RequestID])
REFERENCES [dbo].[Request] ([RequestID])
GO
ALTER TABLE [dbo].[Vote]  WITH CHECK ADD FOREIGN KEY([User_get])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Vote]  WITH CHECK ADD FOREIGN KEY([User_sent])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD CHECK  (([dbo].[ChkValidEmail]([Mail])=(1)))
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD CHECK  (([Role] like 'Student' OR [Role] like 'Tutor' OR [Role] like 'Admin'))
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD CHECK  (([Status] like 'Actived' OR [Status] like 'Banned' OR [Status] like 'Verifying'))
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD CHECK  (([Status] like 'Approved' OR [Status] like 'Waiting'))
GO
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [CK__Request__Status__59063A47] CHECK  (([Status] like 'Approved' OR [Status] like 'Reject' OR [Status] like 'Waiting' OR [Status] like 'On-time' OR [Status] like 'Report'))
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [CK__Request__Status__59063A47]
GO
ALTER TABLE [dbo].[Tutor]  WITH CHECK ADD CHECK  (([Status] like 'Approved' OR [Status] like 'Reject' OR [Status] like 'Waiting'))
GO
USE [master]
GO
ALTER DATABASE [OnlineLearningSystem] SET  READ_WRITE 
GO
/****** Object:  Table [dbo].[Article]    Script Date: 2/7/2022 8:31:52 PM ******/
CREATE TABLE [dbo].[Article](
	[ArticleID] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](max) NULL,
	[description] [text] NULL,
	[imageLink] [nvarchar](max) NULL,
	[published] [datetime] NOT NULL,
	[approved] [bit] NULL,
	[views] [int] NULL,
	[creatorID] [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
