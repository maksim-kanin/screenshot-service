CREATE TABLE IF NOT EXISTS screenshots (
  screenshot_id varchar(250) NOT NULL,
  updated_by varchar(250) NOT NULL,
  update_date varchar(250) NOT NULL,
  updated BOOLEAN NOT NULL,
  PRIMARY KEY (screenshot_id)
);