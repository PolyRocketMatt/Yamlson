<style>
    .img-container {
        text-align: center;
        display: block;
    }

    .overlay {
        position: absolute;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: #008CBA;
        overflow: hidden;
        width: 100%;
        height: 100%;
        transform: scale(0);
        transition: .3s ease;
    }

    .container:hover .overlay {
        transform: scale(1);
    }

/* Some text inside the overlay, which is positioned in the middle vertically and horizontally */
    .text {
        color: white;
        font-size: 20px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        text-align: center;
    }  
</style>

<span class="img-container"> 
    <img src="img/yamlson.png" alt="">
    <div class="overlay">
        <div class="text">Test</div>
    </div>  
</span>

# Yamlson 

Yamlson is small framework that allows the validation and parsing of YAML files or 
strings. Even though it is written with the intent of personal use, it has the ability
to be used in other projects.

## Dependency

Currently, Yamlson is not available as a dependency

---
