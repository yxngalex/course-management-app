drop table if exists CATEGORY;

drop table if exists COMMENT;

drop table if exists COURSE;

drop table if exists "ORDER";

drop index RELATIONSHIP_13_FK on ORDER_DETAILS;

drop table if exists ORDER_DETAILS;

drop table if exists RECEIPT;

drop table if exists REFUND;

drop table if exists ROLE;

drop table if exists USER;

drop table if exists USER_ROLE;

/*==============================================================*/
/* Table: CATEGORY                                              */
/*==============================================================*/
create table CATEGORY
(
   CATEGORY_ID          int not null AUTO_INCREMENT,
   CATEGORY_TYPE        text,
   CATEGORY_NAME        text,
   primary key (CATEGORY_ID)
);

/*==============================================================*/
/* Table: COMMENT                                               */
/*==============================================================*/
create table COMMENT
(
   COMMENT_ID           int not null AUTO_INCREMENT,
   USER_ID              int not null,
   COMMENT              text,
   primary key (COMMENT_ID)
);

/*==============================================================*/
/* Table: COURSE                                                */
/*==============================================================*/
create table COURSE
(
   COURSE_ID            int not null AUTO_INCREMENT,
   CATEGORY_ID          int not null,
   REFUND_ID            int,
   COMMENT_ID           int,
   NAME                 text,
   DESCRIPTION          text,
   PRICE                decimal,
   primary key (COURSE_ID)
);

/*==============================================================*/
/* Table: "ORDER"                                               */
/*==============================================================*/
create table "ORDER"
(
   ORDER_ID             int not null AUTO_INCREMENT,
   AMOUNT               decimal,
   DATE                 date,
   primary key (ORDER_ID)
);

/*==============================================================*/
/* Table: ORDER_DETAILS                                         */
/*==============================================================*/
create table ORDER_DETAILS
(
   ORDER_DETAILS_ID     int not null AUTO_INCREMENT,
   ORDER_ID             int not null,
   COURSE_ID            int not null,
   PRICE                decimal,
   primary key (ORDER_DETAILS_ID)
);

/*==============================================================*/
/* Table: RECEIPT                                               */
/*==============================================================*/
create table RECEIPT
(
   RECEIPT_ID           int not null AUTO_INCREMENT,
   ORDER_DETAILS_ID     int not null,
   DATE                 date,
   primary key (RECEIPT_ID)
);

/*==============================================================*/
/* Table: REFUND                                                */
/*==============================================================*/
create table REFUND
(
   REFUND_ID            int not null AUTO_INCREMENT,
   USER_ID              int not null,
   REFUND_COMMENT       text,
   primary key (REFUND_ID)
);

/*==============================================================*/
/* Table: ROLE                                                  */
/*==============================================================*/
create table ROLE
(
   ROLE_ID              int not null AUTO_INCREMENT,
   NAME                 text,
   primary key (ROLE_ID)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   USER_ID              int not null AUTO_INCREMENT,
   USERNAME             text,
   PASSWORD             text,
   EMAIL                text,
   primary key (USER_ID)
);

/*==============================================================*/
/* Table: USER_ROLE                                             */
/*==============================================================*/
create table USER_ROLE
(
   ID                   int not null AUTO_INCREMENT,
   ROLE_ID              int,
   USER_ID              int,
   primary key (ID)
);

alter table COMMENT add constraint FK_RELATIONSHIP_6 foreign key (USER_ID)
      references USER (USER_ID) on delete CASCADE on update CASCADE;

alter table COURSE add constraint FK_RELATIONSHIP_12 foreign key (COMMENT_ID)
      references COMMENT (COMMENT_ID) on delete CASCADE on update CASCADE;

alter table COURSE add constraint FK_RELATIONSHIP_4 foreign key (CATEGORY_ID)
      references CATEGORY (CATEGORY_ID) on delete CASCADE on update CASCADE;

alter table COURSE add constraint FK_RELATIONSHIP_9 foreign key (REFUND_ID)
      references REFUND (REFUND_ID) on delete CASCADE on update CASCADE;

alter table ORDER_DETAILS add constraint FK_RELATIONSHIP_3 foreign key (ORDER_ID)
      references "ORDER" (ORDER_ID) on delete CASCADE on update CASCADE;

alter table ORDER_DETAILS add constraint FK_RELATIONSHIP_7 foreign key (COURSE_ID)
      references COURSE (COURSE_ID) on delete CASCADE on update CASCADE;

alter table RECEIPT add constraint FK_RELATIONSHIP_11 foreign key (ORDER_DETAILS_ID)
      references ORDER_DETAILS (ORDER_DETAILS_ID) on delete CASCADE on update CASCADE;

alter table REFUND add constraint FK_RELATIONSHIP_10 foreign key (USER_ID)
      references USER (USER_ID) on delete CASCADE on update CASCADE;

alter table USER_ROLE add constraint FK_RELATIONSHIP_1 foreign key (ROLE_ID)
      references ROLE (ROLE_ID) on delete CASCADE on update CASCADE;

alter table USER_ROLE add constraint FK_RELATIONSHIP_2 foreign key (USER_ID)
      references USER (USER_ID) on delete CASCADE on update CASCADE;
