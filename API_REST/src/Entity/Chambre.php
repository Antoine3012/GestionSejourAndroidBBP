<?php

namespace App\Entity;


use App\Repository\ChambreRepository;
use Doctrine\ORM\Mapping as ORM;
use ApiPlatform\Core\Annotation\ApiResource;

/**
 * @ApiResource()
 * @ORM\Entity(repositoryClass=ChambreRepository::class)
 */
class Chambre
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\ManyToOne(targetEntity=Service::class)
     */
    private $numService;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNumService(): ?Service
    {
        return $this->numService;
    }

    public function setNumService(?Service $numService): self
    {
        $this->numService = $numService;

        return $this;
    }
}
