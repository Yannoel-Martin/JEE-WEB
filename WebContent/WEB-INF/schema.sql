-- object: public.forum | type: TABLE --
-- DROP TABLE IF EXISTS public.forum CASCADE;
CREATE TABLE public.forum(
    id serial NOT NULL,
    CONSTRAINT id_forum PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.forum OWNER TO postgres;
-- ddl-end --

-- object: public.topic | type: TABLE --
-- DROP TABLE IF EXISTS public.topic CASCADE;
CREATE TABLE public.topic(
    id serial NOT NULL,
    name varchar(255),
    id_forum integer,
    CONSTRAINT id_topic PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.topic OWNER TO postgres;
-- ddl-end --

-- object: public.discussion | type: TABLE --
-- DROP TABLE IF EXISTS public.discussion CASCADE;
CREATE TABLE public.discussion(
    id serial NOT NULL,
    name varchar(255),
    status smallint,
    id_topic integer,
    CONSTRAINT id_discussion PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.discussion OWNER TO postgres;
-- ddl-end --

-- object: public.message | type: TABLE --
-- DROP TABLE IF EXISTS public.message CASCADE;
CREATE TABLE public.message(
    id serial NOT NULL,
    content text,
    sent_at date,
    id_discussion integer,
    id_user_forum integer,
    CONSTRAINT message_id PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.message OWNER TO postgres;
-- ddl-end --

-- object: public.user_forum | type: TABLE --
-- DROP TABLE IF EXISTS public.user_forum CASCADE;
CREATE TABLE public.user_forum(
    id serial NOT NULL,
    name varchar(255),
    password varchar(255),
    role smallint,
    CONSTRAINT user_id PRIMARY KEY (id)

);
-- ddl-end --
ALTER TABLE public.user_forum OWNER TO postgres;
-- ddl-end --

-- object: forum_fk | type: CONSTRAINT --
-- ALTER TABLE public.topic DROP CONSTRAINT IF EXISTS forum_fk CASCADE;
ALTER TABLE public.topic ADD CONSTRAINT forum_fk FOREIGN KEY (id_forum)
REFERENCES public.forum (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: topic_fk | type: CONSTRAINT --
-- ALTER TABLE public.discussion DROP CONSTRAINT IF EXISTS topic_fk CASCADE;
ALTER TABLE public.discussion ADD CONSTRAINT topic_fk FOREIGN KEY (id_topic)
REFERENCES public.topic (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: discussion_fk | type: CONSTRAINT --
-- ALTER TABLE public.message DROP CONSTRAINT IF EXISTS discussion_fk CASCADE;
ALTER TABLE public.message ADD CONSTRAINT discussion_fk FOREIGN KEY (id_discussion)
REFERENCES public.discussion (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --

-- object: user_forum_fk | type: CONSTRAINT --
-- ALTER TABLE public.message DROP CONSTRAINT IF EXISTS user_forum_fk CASCADE;
ALTER TABLE public.message ADD CONSTRAINT user_forum_fk FOREIGN KEY (id_user_forum)
REFERENCES public.user_forum (id) MATCH FULL
ON DELETE SET NULL ON UPDATE CASCADE;
-- ddl-end --


