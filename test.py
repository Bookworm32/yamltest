import yaml

with open("artefacts.yml", 'r', encoding="utf-8") as stream:
    try:
        print(yaml.load(stream))
    except yaml.YAMLError as exc:
        print(exc)
