#!/bin/bash

set -exo pipefail

export DB_HOST=127.0.0.1
export DB_PORT=3390
export DB_CONN_USER=dahong
export DB_USER_PASS=dahong
export DB_TEST_DATABASE=test_db
export DB_TEST_TABLE=t1