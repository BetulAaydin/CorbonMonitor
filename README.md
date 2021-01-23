# CorbonMonitor
# Carbon concentration rest apis for each defined province's sensor
## Definition
-End point:http://localhost:5000
-I assume that 3 sensor were established in provinces are listed below;
```txt
   Barcelona: Gràcia, Eixample 
   Wien: Währing, 
   Penzing München: Maxvorstadt
 ```
 -I assume that there is a legacy systems which are collect data from sensors and transform them for digital environment. In these way CorbonMonitor project is calling these system to get digital data from each sensors.
  Due to we dont have any rest apis from these legacy systems which we assumed for,I generate dummy data and scheduled it on the  ConcentrationService.java class.

## Using Technologies
```txt
   Spring boot 2.1.0.RELEASE 
   Maven 3
   com.h2database
   Spring security
```

## H2 In Memory DB
```txt
   http://localhost:4040/h2-console
   JDBC URL:jdbc:h2:file:~/test
```
## Get Defined Senonsors

### All senosrs
- curl http://localhost:4040/sensors -u admin:password

```json
[
    {
        "id": 101,
        "name": "SensorSpain",
        "city": "Barcelona",
        "distirict": " Gràcia, Eixample"
    },
    {
        "id": 102,
        "name": "SensorAustria",
        "city": "Wien",
        "distirict": " Währing, Penzing"
    },
    {
        "id": 103,
        "name": "SensorGermany",
        "city": "München",
        "distirict": "Maxvorstadt"
    }
]
```
### sensor by id
-curl http://localhost:4040/sensors/101 -u admin:password

```json
[
   {
    "result_code": "200 OK",
    "message": null,
    "contains": {
        "id": 101,
        "name": "SensorSpain",
        "city": "Barcelona",
        "distirict": " Gràcia, Eixample"
    }
}
]
```

## Retrive Sensor Carbon Concentration between specific dates from each province

### retrive carbon concentration from sensor of Barcelona: Gràcia, Eixample 

-curl -d '{"startDate":"2021-02-01 08:00:42","endDate":"2021-02-01 08:10:42"}'    -H "Content-Type: application/json"   http://localhost:4040/sensor-co2 -u sensor1:password

```json
{
    "result_code": "200 OK",
    "message": null,
    "contains": [
        {
            "id": 1,
            "sensor_def_id": 101,
            "trend_value": 0.14051930828694315,
            "cycle_value": 0.19941810769856017,
            "time": "2021-02-01T08:00:48.387+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 2,
            "sensor_def_id": 101,
            "trend_value": 0.8132151707417921,
            "cycle_value": 0.23910069500304265,
            "time": "2021-02-01T08:00:48.387+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 31,
            "sensor_def_id": 101,
            "trend_value": 0.6422105053499728,
            "cycle_value": 0.2006296645314254,
            "time": "2021-02-01T08:00:49.260+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 32,
            "sensor_def_id": 101,
            "trend_value": 0.6099529010804172,
            "cycle_value": 0.999989116500999,
            "time": "2021-02-01T08:00:49.260+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 44,
            "sensor_def_id": 101,
            "trend_value": 0.7631053959881219,
            "cycle_value": 0.9432987803978348,
            "time": "2021-02-01T08:00:49.321+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 46,
            "sensor_def_id": 101,
            "trend_value": 0.15853472454968187,
            "cycle_value": 0.4591962704432273,
            "time": "2021-02-01T08:00:49.321+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 3,
            "sensor_def_id": 101,
            "trend_value": 0.8208754340201015,
            "cycle_value": 0.5204065006489303,
            "time": "2021-02-01T08:01:48.387+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 33,
            "sensor_def_id": 101,
            "trend_value": 0.6040690598116699,
            "cycle_value": 0.9456022068381543,
            "time": "2021-02-01T08:01:49.260+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 48,
            "sensor_def_id": 101,
            "trend_value": 0.20409608768453336,
            "cycle_value": 0.542884669954975,
            "time": "2021-02-01T08:01:49.321+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 4,
            "sensor_def_id": 101,
            "trend_value": 0.2512199360667059,
            "cycle_value": 0.7461451868437914,
            "time": "2021-02-01T08:03:48.387+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 34,
            "sensor_def_id": 101,
            "trend_value": 0.32321638773915273,
            "cycle_value": 0.26612109901208447,
            "time": "2021-02-01T08:03:49.260+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 50,
            "sensor_def_id": 101,
            "trend_value": 0.23174589725781714,
            "cycle_value": 0.10253228844702245,
            "time": "2021-02-01T08:03:49.321+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 5,
            "sensor_def_id": 101,
            "trend_value": 0.7755161924111087,
            "cycle_value": 0.1857382537099851,
            "time": "2021-02-01T08:06:48.387+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 35,
            "sensor_def_id": 101,
            "trend_value": 0.9114403045908702,
            "cycle_value": 0.579926563390055,
            "time": "2021-02-01T08:06:49.260+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        },
        {
            "id": 51,
            "sensor_def_id": 101,
            "trend_value": 0.4618375352765157,
            "cycle_value": 0.7027939544332129,
            "time": "2021-02-01T08:06:49.321+0000",
            "sensorDefinition": {
                "id": 101,
                "name": "SensorSpain",
                "city": "Barcelona",
                "distirict": " Gràcia, Eixample"
            }
        }
    ]
}
```

### retrive carbon concentration from sensor of  Wien: Währing, 


-curl -d '{"startDate":"2021-02-01 08:00:42","endDate":"2021-02-01 08:10:42"}'    -H "Content-Type: application/json"   http://localhost:4040/sensor-co2 -u sensor2:password



### retrive carbon concentration from sensor of  Wien: Währing, 
   Penzing München: Maxvorstadt 

-curl -d '{"startDate":"2021-02-01 08:00:42","endDate":"2021-02-01 08:10:42"}'    -H "Content-Type: application/json"   http://localhost:4040/sensor-co2 -u sensor3:password



