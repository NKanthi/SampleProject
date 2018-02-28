import time

import redis
from flask import Flask
from flask import Response
from flask import json

app = Flask(__name__)
cache = redis.Redis(host='redis', port=6379)


def get_hit_count():
    retries = 5
    while True:
        try:
            return cache.incr('hits')
        except redis.exceptions.ConnectionError as exc:
            if retries == 0:
                raise exc
            retries -= 1
            time.sleep(0.5)


@app.route('/test')
def test():
    count = get_hit_count()
    return 'Hello World! I have been seen {} times.\n'.format(count)


@app.route('/')
def hello():
    data = {
        'hello'  : 'world',
        'number' : 3
    }
    js = json.dumps(data)

    resp = Response(js, status=200, mimetype='application/json')

    return resp

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=80, debug=True)